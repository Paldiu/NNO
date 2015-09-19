package me.Paldiu.NNO.Commands;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import me.Paldiu.NNO.Commands.CommandPermissions;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandParameters
{
    String name();

    String description();

    String usage();

    String aliases() default "";

    CommandPermissions permission() default CommandPermissions.defaultLevel;
}
