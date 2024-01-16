package org.example.hw7;

import com.sun.source.util.JavacTask;
import com.sun.source.util.Plugin;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory){
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName){
        return new Plugin() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public void init(JavacTask task, String... args) {

            }
        };
    }
}
