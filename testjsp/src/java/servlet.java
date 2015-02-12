/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ListeTravailleur;
import model.Travailleur;


/**
 *
 * @author 0804jumartin
 */
@WebServlet(urlPatterns = {"/servlet"})
public class servlet extends HttpServlet {

    public static final String VUE = "/WEB-INF/form.jsp";
    public static final String NOM = "Nom";
    public static final String PRENOM = "Prenom";
    public static final String TEL = "tel";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //String resultat;
        //Map<String, String> erreurs = new HashMap<String, String>();
        
        String nom = request.getParameter(NOM);
        String prenom = request.getParameter(PRENOM);
        String tel = request.getParameter(TEL);

        try {
            validationNom(nom);
            validationPrenom(prenom);
            validationTel(tel);
        } catch (Exception e) {
            /* Gérer les erreurs de validation ici. */
        }
        
        System.out.println(nom +" " + prenom +" "+tel);
        LinkedList<Travailleur> ls = new LinkedList<>();
        ls =ListeTravailleur.search(nom) ;
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("ListeTravailleur", ls);

        this.getServletContext().getRequestDispatcher("/WEB-INF/reponsejsp.jsp").forward(request, response);
/*        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println(nom +" " + prenom +" "+tel);            
            out.println("</body>");
            out.println("</html>");
        }
  */  
    }

    private void validationNom(String nom) throws Exception {
        if ( nom != null && nom.trim().length() < 2 ) {
        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
    }
    }

    private void validationPrenom(String prenom) throws Exception {
        if ( prenom != null && prenom.trim().length() < 2 ) {
        throw new Exception( "Le prenom d'utilisateur doit contenir au moins 3 caractères." );
    }
    }

    private void validationTel(String tel) throws Exception {
        if ( tel != null && tel.trim().length() < 1 ) {
        throw new Exception( "Le téléphone de l'utilisateur doit contenir au moins 1 chiffres." );
    }
    }
}
