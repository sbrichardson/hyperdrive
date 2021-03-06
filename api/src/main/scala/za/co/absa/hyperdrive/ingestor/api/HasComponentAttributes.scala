/*
 * Copyright 2018 ABSA Group Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package za.co.absa.hyperdrive.ingestor.api

case class PropertyMetadata(
                             /**
                              * A human readable label for this property.
                              */
                             label: String,

                             /**
                              * An optional text that gives a detailed description of this property.
                              */
                            hint: Option[String],

                             /**
                              * true if the property is required, false otherwise
                              */
                            required: Boolean)

/**
 * This trait should be implemented by all implementations of [[ComponentFactory]] to provide a self-description
 * how the component should be used and configured. This information may be used by external applications
 * that automatically discover components
 */
trait HasComponentAttributes {
  /**
   * @return a human readable name of the component.
   */
  def getName: String

  /**
   * @return a description for the component.
   */
  def getDescription: String

  /**
   * @return a map describing configuration properties for this component. The keys have to be unique to avoid
   *         name clashes with properties from other components.
   */
  def getProperties: Map[String, PropertyMetadata]

  /**
   * @return a prefix to be used for arbitrary extra configuration. Typically extra configuration is required
   *         to pass on configuration properties, e.g. to DataStreamWriter.options
   */
  def getExtraConfigurationPrefix: Option[String] = None
}
