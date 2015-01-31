package org.wadael.commands;

import org.jboss.forge.addon.ui.annotation.Command;
import org.jboss.forge.addon.ui.result.Result;
import org.jboss.forge.addon.ui.result.Results;


public class SuperSimple {
	
	@Command(categories={"simple","exemple"}, value="aaalors")
	public Result onNePeuxPasFairePlusSimple(){
		return Results.success("Meunier, tu dors ?");
		
	}
	
}
