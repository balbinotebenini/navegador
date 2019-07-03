/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser.Classes;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BalbiNOTE
 */
public class GetUrlTest {

    /**
     * Test of arvore method, of class GetUrl.
     */
    @Test
    public void testGetTagConteudo_4args() {
        String html = "<html><head>testeHead</head><body>testeBody<p>testeLinha</p></body></html>";
        String p = GetUrl.getFirstTagConteudo(html, "p", false, true);
        assertEquals(p, "testeLinha");
    }

    @Test
    public void testdecodeSpecialHTMLChars() {
        String caracSpecial = "chitãozinho & xororó";
        String x = GetUrl.decodeSpecialHTMLChars("&");
        assertEquals(x, "&");
    }

    @Test
    public void tagRemov() {
        String remove = "<b";
        String r = GetUrl.tagRemov(remove, "<b");
        assertEquals(r, "<b");
    }
}
