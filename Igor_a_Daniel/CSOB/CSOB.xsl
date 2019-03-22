<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" >
<xsl:output method="text" omit-xml-declaration="yes" indent="no"/>
<xsl:template match="/">
M�na,Zem�,Mno�stv�,DN�kup,DProdej,DSt�ed,DZm�na,VN�kup,VProdej,VSt�ed,VZm�na
<xsl:for-each select="/Country">
<xsl:value-of select="ExchangeRate/Country/@ID"/>
<xsl:value-of select="ExchangeRate/Country/@Country"/>
<xsl:value-of select="ExchangeRate/Country/@quota"/>
<xsl:value-of select="ExchangeRate/CountryFXcashless/@Buy"/>
<xsl:value-of select="ExchangeRate/CountryFXcashless/@Sale"/>
<xsl:value-of select="ExchangeRate/CountryFXcashless/@Middle"/>
<xsl:value-of select="ExchangeRate/CountryFXcashless/@Change"/>
<xsl:value-of select="ExchangeRate/CountryFXcash/@Buy"/>
<xsl:value-of select="ExchangeRate/CountryFXcash/@Sale"/>
<xsl:value-of select="ExchangeRate/CountryFXcash/@Middle"/>
<xsl:value-of select="ExchangeRate/CountryFXcash/@Change"/>
</xsl:for-each>
</xsl:template>
</xsl:stylesheet>