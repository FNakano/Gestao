<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<!-- transformação identidade -->
<xsl:template match="/ | @* | node()">
  <xsl:value-of select ="name(.)"/> <!-- a saída faz mais sentido se imprimir preordem. xsl:value-of imprime, não precisa, nem pode, estar dentro de xsl:text -->
  <xsl:copy>
    <xsl:apply-templates select="@* | node()" />
  </xsl:copy>
</xsl:template>
</xsl:stylesheet>
