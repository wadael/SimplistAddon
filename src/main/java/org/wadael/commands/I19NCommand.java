package org.wadael.commands;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.jboss.forge.addon.ui.command.AbstractUICommand;
import org.jboss.forge.addon.ui.context.UIBuilder;
import org.jboss.forge.addon.ui.context.UIContext;
import org.jboss.forge.addon.ui.context.UIExecutionContext;
import org.jboss.forge.addon.ui.context.UIValidationContext;
import org.jboss.forge.addon.ui.facets.HintsFacet;
import org.jboss.forge.addon.ui.hints.InputType;
import org.jboss.forge.addon.ui.input.UIInput;
import org.jboss.forge.addon.ui.input.UISelectOne;
import org.jboss.forge.addon.ui.metadata.UICommandMetadata;
import org.jboss.forge.addon.ui.metadata.WithAttributes;
import org.jboss.forge.addon.ui.result.Result;
import org.jboss.forge.addon.ui.result.Results;
import org.jboss.forge.addon.ui.util.Categories;
import org.jboss.forge.addon.ui.util.Metadata;

public class I19NCommand extends AbstractUICommand {
	public static List<String> PAYS ; 
	
	@Inject
	private UIInput<String> folder;

	@Inject
	@WithAttributes(label="language",required=true, description="New language to support" )
	private UISelectOne<String> language ;
	
	public I19NCommand() {
		PAYS = new ArrayList<>();
		PAYS.add("fr");
		PAYS.add("de");
		PAYS.add("ar");
		PAYS.add("dg"); // variante de franco-breton :)
	}
	
	@Override
	public UICommandMetadata getMetadata(UIContext context) {
		return Metadata.forCommand(I19NCommand.class).name("addNewLanguage").category(Categories.create("Android")).description("Adds a new supported language to the application.");
	}
	
	@Override
	public void initializeUI(UIBuilder builder) throws Exception {
		language.setValueChoices(PAYS);
		language.setRequired(true);
		language.setDescription("New language to support");
		folder.getFacet(HintsFacet.class).setInputType(InputType.DIRECTORY_PICKER);
		folder.setRequired(true);
		builder.add(folder);
		builder.add(language);
	}

	@Override
	public void validate(UIValidationContext validator) {
		super.validate(validator);
		// Rien d'autre à vérifier avec ces composants.
	}

	@Override
	public Result execute(UIExecutionContext context) throws Exception {
		File master = new File(folder.getValue() + File.separator + "res" + File.separator + "values" + File.separator + "strings.xml");
		File dest = new File(folder.getValue() + File.separator + "res" + File.separator + "values" + File.separator + "strings_" + language.getValue() + ".xml");
	
		FileUtils.copyFile(master, dest);
		return Results.success("COPIE faite : fichier " + dest.getAbsolutePath() + " créé !");
	}
}