input {
	file{
        path =>"${path}"
	type => "${type}"
	start_position => "beginning"
		}
}
filter {
    
	  [<#list countries as country>"${country}", </#list>]
      
    }
}

output {
		elasticsearch{
			action => "index"
			hosts => "localhost"
			index => "${indexCible}"
			workers => "stoun"
		}
		stdout{
			codec => rubydebug
		}
}