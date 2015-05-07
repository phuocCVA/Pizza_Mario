/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pizza_client;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author ivy
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Mario_pizza/MarioWebService.wsdl")
    private MarioWebService_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        String xml = ( " <ns1:commande  xmlns:xsi="+ "'" + " http://www.w3.org/2001/XMLSchema-instance' \n "
                                 + " xmlns:ns1='http://chez.mario.fr/commande' \n"
                                 + " xmlns:ns2='http://chez.mario.fr/client' \n"
                                 + " xmlns:ns3='http://chez.mario.fr/pizza' \n"
                                 + " xsi:schemaLocation='http://chez.mario.fr/commande commande.xsd'> \n");
        if(!request.getParameter("noAdherent").isEmpty()) {
              xml +=" <ns1:client noAdherent='"+request.getParameter("noAdherent")+"'> \n" ; }     
        else  xml +=(" <ns1:client> \n");
        xml += (" <ns2:nom>"+request.getParameter("nom")+"</ns2:nom> \n"
                + " <ns2:prénom>"+request.getParameter("prenom")+"</ns2:prénom> \n"
                + " <ns2:téléphone>"+request.getParameter("telephone")+"</ns2:téléphone> \n"
                + " <ns2:adresse>"+request.getParameter("adresse")+"</ns2:adresse> \n"
            + " </ns1:client> \n"
            + " <ns1:pizza> \n"
                + " <ns3:base>"+request.getParameter("base")+"</ns3:base> \n"
                + " <ns3:ingrédients> \n" );
        
        for(int i=1;i<=12;i++){
            String tt= "ingredients"+i ;
            if(request.getParameter(tt)!=null)
                xml+= "<ns3:ingrédient>"+request.getParameter(tt)+"</ns3:ingrédient> \n";
        }
           
        xml+=   ( "</ns3:ingrédients> \n"
                + " <ns3:taille>"+request.getParameter("taille")+"</ns3:taille> \n"
                + " </ns1:pizza> \n"
                + " </ns1:commande> \n" );
        String str=addCommande(xml);
        String str1=transformer(xml);
        out.println(str1);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String addCommande(java.lang.String filename) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pizza_client.MarioWebService port = service.getMarioWebServicePort();
        return port.addCommande(filename);
    }

    private String transformer(java.lang.String xml) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pizza_client.MarioWebService port = service.getMarioWebServicePort();
        return port.transformer(xml);
    }


  
}
