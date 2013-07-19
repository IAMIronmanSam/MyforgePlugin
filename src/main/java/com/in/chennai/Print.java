package com.in.chennai;

import java.util.Arrays;

import javax.inject.Inject;

import org.jboss.forge.shell.ShellPrompt;
import org.jboss.forge.shell.plugins.Alias;
import org.jboss.forge.shell.plugins.Command;
import org.jboss.forge.shell.plugins.DefaultCommand;
import org.jboss.forge.shell.plugins.Option;
import org.jboss.forge.shell.plugins.PipeIn;
import org.jboss.forge.shell.plugins.PipeOut;
import org.jboss.forge.shell.plugins.Plugin;

/**
 *
 */
@Alias("mybot")
public class Print implements Plugin
{
   @Inject
   private ShellPrompt prompt;

   @DefaultCommand
   public void defaultCommand(@PipeIn String in, PipeOut out)
   {
      out.println("Executed default command.");
   }

   @Command("command")

   public void command(@PipeIn String in, PipeOut out, @Option String... args)
   {
      if (args == null)
         out.println("Executed named command without args.");
      else
         out.println("Executed named command with args: " + Arrays.asList(args));
   }

   @Command("prompt")
   public void prompt(@PipeIn String in, PipeOut out)
   {
      if (prompt.promptBoolean("Do you like writing Forge plugins?"))
         out.println("I am happy.");
      else
         out.println("I am sad.");
   }
   @Command("perform")
   public void exampleCommand(
                  @Option(name="one", shortName="1") String one,
                  @Option(name="two",shortName="2") String two,
                  PipeOut out) {
      if(one != null){out.println(">> option one equals: " + one);}
      if(two != null){out.println(">> option two equals: " + two);}
   }
}
