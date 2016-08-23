FreeMarker Template example: ${path}  ${type} ${indexCible}

=======================
===  County List   ====
=======================
<#list countries as country>
	${country_index + 1}. ${country}
</#list>