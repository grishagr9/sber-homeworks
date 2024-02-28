package org.example.hw7;

import com.sun.source.util.JavacTask;
import com.sun.source.util.Plugin;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory){
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName){
        //todo Соответственно, разные
        //разработчики могут назвать свои классы одинаковым именем, ваш загрузчик должен корректно
        //это обрабатывать.
        //PluginManager ищет скомпилированные классы плагина в папке pluginRootDirectory\pluginName\
        return null;
    }
}
