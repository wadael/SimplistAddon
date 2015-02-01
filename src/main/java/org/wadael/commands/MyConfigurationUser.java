package org.wadael.commands;

import javax.inject.Inject;

import org.jboss.forge.addon.ui.annotation.Command;
import org.jboss.forge.addon.ui.result.Result;
import org.jboss.forge.addon.ui.result.Results;

public class MyConfigurationUser {
	@Inject
	MyConfiguration conf ;
	
	@Command(value="affiche-valeur1",categories="metier")
	public Result afficheLaValeurMetier(){
		String leopard = conf.getLaValeurMetier();
		if(leopard==null) return Results.fail("Pas de valeur pour " + MyConfiguration.CLEF);
		return Results.success(MyConfiguration.CLEF + " vaut " + leopard );
	}
}
