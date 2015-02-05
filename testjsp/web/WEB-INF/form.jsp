<%-- 
    Document   : form
    Created on : 05-févr.-2015, 21:06:56
    Author     : 0804jumartin
--%>

<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="servlet">
            <fieldset>
                <legend>Formulaire de recherche</legend>
                <p>Vous pouvez rechercher des personnes via ce formulaire.</p>

                <label for="Nom">Nom </label>
                <input type="text" id="Nom" name="Nom" value="" size="20" maxlength="60" />
                <br />

                <label for="Prenom">Prénom </label>
                <input type="Prenom" id="Prenom" name="Prenom" value="" size="20" maxlength="60" />
                <br />

                <label for="tel">Numéro de téléphone </label>
                <input type="tel" id="tel" name="tel" value="" size="20" maxlength="20" />
                <br />


                <input type="submit" value="Ok" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</html>
