package collins.guava

import collins.util.config.Configurable
import com.google.common.cache.CacheBuilderSpec

object GuavaConfig extends Configurable {
  override val namespace = "guava"
  override val referenceConfigFilename = "guava_reference.conf"

  def enabled = getBoolean("enabled", true)
  def specification = getString("specification", "maximumSize=10000,expireAfterWrite=10s,recordStats")

  override protected def validateConfig() {
    logger.debug(s"Guava config enabled - $enabled")
    if (enabled) {
      CacheBuilderSpec.parse(specification)
    }
  }
}