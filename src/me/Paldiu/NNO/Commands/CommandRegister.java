package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;

public class CommandRegister {

	public static void registerCommands() {
		registerCommand(new Achgiv());
		registerCommand(new AdminChat());
		registerCommand(new AdminMode());
		registerCommand(new Anal());
		registerCommand(new Aoap());
		registerCommand(new Bhrp());
		registerCommand(new Cake());
		registerCommand(new ChatBot());
		registerCommand(new ChatClear());
		registerCommand(new Cuil());
		registerCommand(new Deafen());
		registerCommand(new Debug());
		registerCommand(new Devconf());
		registerCommand(new Dragon());
		registerCommand(new Emsd());
		registerCommand(new Freeze());
		registerCommand(new Fuckoff());
		registerCommand(new Gcmd());
		registerCommand(new Gold());
		registerCommand(new Jelly());
		registerCommand(new Lockdown());
		registerCommand(new Lockup());
		registerCommand(new Ltg());
		registerCommand(new Meep());
		registerCommand(new Nno());
		registerCommand(new Nope());
		registerCommand(new Ntoggle());
		registerCommand(new Onsa());
		registerCommand(new Packnenil());
		registerCommand(new Penis());
	}

	private static void registerCommand(Object commandHandler) {
		CommandController.registerCommands(Main.getInstance(), commandHandler);
	}

}
