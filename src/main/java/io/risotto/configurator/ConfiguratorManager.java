package io.risotto.configurator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Manager class that holds the list of default configurators. These are the configurators that will
 * be called on all containers when configuring the container tree. Custom configurators can be
 * registered using the {@link #registerDefaultConfigurator(Configurator...)} method.
 */
public class ConfiguratorManager {
  private static final List<Configurator> defaultConfiguratorList =
      new ArrayList<>();

  static {
    registerDefaultConfigurator(new ChildConfigurator(), new BindingConfigurator());
  }

  /**
   * Registers the specified {@code Configurator}s among the default configurators.
   * @param configurators the configurators to register
   */
  public static void registerDefaultConfigurator(Configurator... configurators) {
    defaultConfiguratorList.addAll(Arrays.asList(configurators));
  }

  /**
   * Gets the list of default configurators.
   * @return the list of default configurators
   */
  public static List<Configurator> getDefaultConfigurators() {
    return defaultConfiguratorList;
  }
}
