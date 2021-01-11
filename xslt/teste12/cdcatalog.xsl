<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="3.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output indent="yes" />

<xsl:template match="/">
<html> 
<body>
  <h2>My CD Collection</h2>
    <xsl:apply-templates />
</body>
</html>
</xsl:template>

<!-- transformação identidade -->
<!-- <xsl:template match="/ | @* | node()"> no ff68, manter esta linha dá algum erro não reportado. -->
<xsl:template match="@* | node()"> <!-- no ff68,  -->
  <xsl:element name="p">
    <xsl:value-of select ="name(.)"/> <!-- a saída faz mais sentido se imprimir preordem. xsl:value-of imprime, não precisa, nem pode, estar dentro de xsl:text -->
  </xsl:element>
  <xsl:copy>
    <xsl:apply-templates select="@* | node()" />
  </xsl:copy>
</xsl:template>


</xsl:stylesheet>
