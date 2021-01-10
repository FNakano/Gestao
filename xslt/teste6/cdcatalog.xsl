<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<!-- Segundo exemplo da resposta mais votada em 
https://stackoverflow.com/questions/953197/how-do-you-output-the-current-element-path-in-xslt/10112579
Dados para ajudar a identificasr a resposta:
edited Apr 15 '14 at 19:08
answered Apr 11 '12 at 19:25
Daniel Haley
Nota: o primeiro exemplo está incompleto.
Pode ser que a transformação não funcione conforme eu espero no meu arquivo, mas funciona no exemplo do documento do link. Vou substituir o meu arquivo pelo arquivo usado no teste.
Criei conteudo2.xml, que aplica a transformação sobre o exemplo da referência acima. O resultado é uma página em branco.

 -->
  <xsl:output indent="yes"/>
  <xsl:strip-space elements="*"/>

  <xsl:template match="text()|@*">
    <xsl:copy>
      <xsl:apply-templates select="node()|@*"/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="*">
    <xsl:copy>
      <xsl:attribute name="path">
        <xsl:call-template name="genPath"/>
      </xsl:attribute>
      <xsl:apply-templates select="node()|@*"/>
    </xsl:copy>    
  </xsl:template>

  <xsl:template name="genPath">
    <xsl:param name="prevPath"/>
    <xsl:variable name="currPath" select="concat('/',name(),'[',
      count(preceding-sibling::*[name() = name(current())])+1,']',$prevPath)"/>
    <xsl:for-each select="parent::*">
      <xsl:call-template name="genPath">
        <xsl:with-param name="prevPath" select="$currPath"/>
      </xsl:call-template>
    </xsl:for-each>
    <xsl:if test="not(parent::*)">
      <xsl:value-of select="$currPath"/>      
    </xsl:if>
  </xsl:template>

</xsl:stylesheet>

