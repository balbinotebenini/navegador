package webbrowser.Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetUrl {

    public static Conteudo arvore(String url) {
        String pagina = "";
        try {
            URL website = new URL(url);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(website.openConnection().getInputStream()))) {
                String s;
                while ((s = br.readLine()) != null) {
                    pagina += s;
                }
            }
        } catch (MalformedURLException ex) {
            System.out.println("URL inválida");
            Logger.getLogger(GetUrl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GetUrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (pagina.isEmpty()) {
            return null;
        }
       Conteudo conteudo = processaFolha(pagina);
       mostraResultado(conteudo, true);
       return conteudo;
    }

    private static Conteudo processaFolha(String pagina) {
        pagina = getFirstTagConteudo(pagina, "body", false, true);
        Conteudo conteudo = new Conteudo("body", pagina, null);
        while (true) {
            pagina = processaLinha(pagina, conteudo);
            if (pagina == null || pagina.isEmpty()) {
                break;
            }
        }
        return conteudo;
    }

    private static void mostraResultado(Conteudo conteudo, boolean onliLast) {
        if (conteudo == null) {
            return;
        }
        if (onliLast) {
            if (conteudo.getChildren() == null || conteudo.getChildren().isEmpty()) {
                System.out.println("Tag <" + conteudo.getTag() + "> FOLHA >" + conteudo.getFolha());
            }
        } else {
            System.out.println("Tag <" + conteudo.getTag() + "> FOLHA >" + conteudo.getFolha());
        }
        if (conteudo.getChildren() != null) {
            for (Conteudo c : conteudo.getChildren()) {
                mostraResultado(c, onliLast);
            }
        }
    }

    private static String processaLinha(String pagina, Conteudo conteudo) {
        try {
            while (true) {
                String tag = "";
                if (pagina == null || pagina.isEmpty()) {
                    break;
                }
                int posIni = pagina.indexOf("<") + 1;
                if (posIni == 0) {
                    return null;
                }
                for (int i = posIni; i < pagina.length(); i++) {
                    String val = pagina.substring(i, i + 1);
                    if (val.equals(" ") || val.equals("/") || val.equals(">")) {
                        break;
                    }
                    tag += val;
                }
                if (tag.isEmpty()) {
                    return null;
                }
                String folha = getFirstTagConteudo(pagina, tag, false, true);
                if (folha == null || folha.isEmpty()) {
                    pagina = pagina.substring(pagina.indexOf(">"));
                    return processaLinha(pagina, conteudo);
                }
                Conteudo cont = new Conteudo(tag, folha, null);
                processaLinha(folha, cont);
                conteudo.addChild(cont);
                pagina = tagRemov(pagina, tag);
                if (pagina == null || pagina.isEmpty()) {
                    break;
                }
                pagina = processaLinha(pagina, conteudo);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
        return null;
    }

    public static String tagRemov(String html, String tag) {
        if (html == null || tag == null) {
            return null;
        }
        String tag1 = "<" + tag;
        String tag2 = "</" + tag + ">";

        int pos1 = html.indexOf(tag1);
        if (pos1 == -1) {
            return html;
        }
        int pos2 = html.indexOf(tag2);

        String html1 = html.substring(0, pos1);
        String html2 = html.substring(pos2 + tag2.length());

        return html1 + html2;
    }

    public static List<String> getTagConteudo(String html, String nomeTag, boolean incluirTag, boolean decodeSpecialChars) {
        if ((html == null) || (nomeTag == null)) {
            return null;
        }
        List<String> tags = new ArrayList();
        String regex = "(<\\s*[/]{0,1}\\s*#NOME_TAG#(\\s+[^<]*|\\s*)>|<\\s*#NOME_TAG#(\\s+[^<]*|\\s*)/{0,1}\\s*>)".replace("#NOME_TAG#", nomeTag);
        Matcher matcher = Pattern.compile(regex).matcher(html);
        int start = 0;
        int end = 0;
        int diff = incluirTag ? 1 : 0;
        String group = null;
        while (matcher.find(start)) {
            if (incluirTag) {
                start = matcher.start();
            } else {
                start = matcher.end();
            }
            group = matcher.group();
            if (Pattern.matches("<[^><]*/\\s*>", group)) {
                if (incluirTag) {
                    tags.add(a(group, decodeSpecialChars));
                    start += diff;
                }
            } else {
                matcher.find(start + diff);
                if (incluirTag) {
                    end = matcher.end();
                } else {
                    end = matcher.start();
                }
                tags.add(a(html.substring(start, end), decodeSpecialChars));
                start = matcher.end();
            }
        }
        return tags.isEmpty() ? null : tags;
    }

    private static String a(String str, boolean decodeSpecialChars) {
        return decodeSpecialChars ? decodeSpecialHTMLChars(str) : str;
    }

    public static String decodeSpecialHTMLChars(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("&amp;", "&").replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&quot;", "\"").replaceAll("&#39;", "'");
    }

    public static List<String> getTagConteudo(String html, String nomeTag, boolean incluirTag) {
        return getTagConteudo(html, nomeTag, incluirTag, false);
    }

    public static String getFirstTagConteudo(String html, String nomeTag, boolean incluirTag, boolean decodeSpecialChars) {
        try {
            List<String> list = getTagConteudo(html, nomeTag, incluirTag, decodeSpecialChars);
            if ((list != null) && (!list.isEmpty())) {
                return (String) list.get(0);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}

class Conteudo {

    String tag;
    String folha;
    List<Conteudo> children;

    public Conteudo(String tag, String folha, List<Conteudo> children) {
        this.tag = tag;
        this.folha = folha;
        this.children = children;
    }

    public Conteudo() {
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFolha() {
        return folha;
    }

    public void setFolha(String folha) {
        this.folha = folha;
    }

    public List<Conteudo> getChildren() {
        return children;
    }

    public void setChildren(List<Conteudo> children) {
        this.children = children;
    }

    void addChild(Conteudo cont) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(cont);
    }
}

