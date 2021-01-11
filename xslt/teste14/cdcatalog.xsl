<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="3.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output indent="yes" />

<xsl:template match="/">
<html> 
<body>
  <h2>My CD Collection</h2>
    <xsl:apply-templates>
      <xsl:with-param name="paramEspacos" select="name(.)" />
    </xsl:apply-templates>
</body>
</html>
</xsl:template>

<!-- transformação identidade -->
<!-- <xsl:template match="/ | @* | node()"> no ff68, manter esta linha dá algum erro não reportado. -->
<xsl:template match="@* | node()"> <!-- no ff68,  -->
  <xsl:param name="paramEspacos" />
  <pre>
    <xsl:value-of select = "concat($paramEspacos,'/',name(.))"/> <!-- coloca uma quantidade de espaços proporcional ao nível de recursão. -->
  </pre>
  <xsl:copy>
    <xsl:apply-templates select="@* | node()" >
      <xsl:with-param name="paramEspacos" select="concat($paramEspacos,'/',name(.))" /> <!-- a cada nível, acrescenta dois espaços quando falta o $, falha sem mensagem de erro. -->
    </xsl:apply-templates>
  </xsl:copy>
</xsl:template>

<!-- não sei por que escreve uma linha a mais. -->
</xsl:stylesheet>
