package org.wadael.commands;

import org.jboss.forge.addon.ui.command.AbstractUICommand;
import org.jboss.forge.addon.ui.context.UIBuilder;
import org.jboss.forge.addon.ui.context.UIContext;
import org.jboss.forge.addon.ui.context.UIExecutionContext;
import org.jboss.forge.addon.ui.metadata.UICommandMetadata;
import org.jboss.forge.addon.ui.util.Metadata;
import org.jboss.forge.addon.ui.util.Categories;
import org.jboss.forge.addon.ui.result.Result;
import org.jboss.forge.addon.ui.result.Results;
import java.lang.Override;
import java.lang.Exception;
/**
 * Exemple de commande simpliste selon le modèle "Moins simple mais mieux"
 * 
 * @author jerome
 *
 */
public class HelloDennisRitchie extends AbstractUICommand {

	@Override
	public UICommandMetadata getMetadata(UIContext context) {
		return Metadata.forCommand(HelloDennisRitchie.class).name("hello-dennis-ritchie").category(Categories.create("exemple"));
	}

	@Override
	public void initializeUI(UIBuilder builder) throws Exception {
	}

	@Override
	public Result execute(UIExecutionContext context) throws Exception {
		return Results.success("Au revoir Dennis Ritchie, merci pour tout !");
	}
}