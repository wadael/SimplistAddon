package org.wadael.commands;

import javax.inject.Inject;

import org.jboss.forge.addon.configuration.Configuration;
import org.jboss.forge.addon.ui.annotation.Command;
import org.jboss.forge.addon.ui.annotation.Option;
import org.jboss.forge.addon.ui.result.Result;
import org.jboss.forge.addon.ui.result.Results;

public class MyConfiguration {
	public static final String CLEF = "maClef_Valeur1";
	
	@Inject
	private Configuration conf;
	
	@Command(value="set-valeur1",categories="metier")
	public Result setLaValeurMetier(
		@Option(value = "valeur", label = "Quelle valeur donner ?", required = true, type = "String", defaultValue = "8000", enabled = true) 
		String valeur){
		conf.setProperty(CLEF, valeur);		
        return Results.success(CLEF +" vaut desormais " + conf.getString(CLEF));
	}

	
	public String getLaValeurMetier(){
		return conf.getString(CLEF);
	}
}
