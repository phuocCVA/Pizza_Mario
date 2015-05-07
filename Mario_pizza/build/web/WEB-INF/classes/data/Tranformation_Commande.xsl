<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:ns1="http://chez.mario.fr/commande"
                xmlns:ns2="http://chez.mario.fr/client"
                xmlns:ns3="http://chez.mario.fr/pizza">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>COMMANDE</title>
                <meta name="viewport" content="width=device-width"/>
                <link rel="stylesheet" type="text/css" href="Style.css"/>
            </head>
            <body>
                <div id="wrapper"> 
                   <img src="image/pizza.jpg" alt="pizza"/>
                </div>
                <div id="wrapper">
                    <ul class="menu">
                         <li><a href="Accueil.xhtml" ><span>Accueil</span></a>  </li>
                         <li><a href="Webmasters.xhtml" ><span>Web Masters</span></a>  </li>
                        <li><a href="Commande.xhtml" ><span>Passer une commande</span></a>  </li>
                        <li><a href="Livrer.xhtml" ><span>Livrer une commande</span></a>  </li> 
                    </ul>
                </div>
                <div id="wrapper">
                    <div id="body">
                        <center> 
                            <h1> Merci de Votre Commande </h1> 
                        </center>
                        
                        <fieldset>
                            <legend>Votre Commande</legend><br/>
                            <xsl:apply-templates select="ns1:commande/ns1:pizza"/>
                        </fieldset>
                        <br/>
                        <fieldset>
                            <legend>Votre Informations</legend><br/>
                            <xsl:apply-templates select="ns1:commande/ns1:client"/>
                        </fieldset>
                    </div>
                </div>   
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="ns1:pizza">
        <label>Base:  </label> <xsl:value-of select="ns3:base"/> 
        <br/><br/>
        <label>Taille:  </label> <xsl:value-of select="ns3:taille"/> 
        <br/><br/>
        <label>Ingredients:</label>
        <xsl:value-of select="count(//ns3:ingrédient)"/> ingredients:
        <xsl:value-of select="ns3:ingrédients"/>  
        <br/><br/>        
    </xsl:template>  
    
    <xsl:template match="ns1:client">
        <label>Nom:  </label> <xsl:value-of select="ns2:nom"/>
        <br/><br/>
        <label>Prénom:  </label> <xsl:value-of select="ns2:prénom"/> 
        <br/><br/>
        <label>Téléphone: </label> <xsl:value-of select="ns2:téléphone"/> 
        <br/><br/>     
        <label>Adresse: </label> <xsl:value-of select="ns2:adresse"/> 
        <br/><br/>     
    </xsl:template>  
    

</xsl:stylesheet>
