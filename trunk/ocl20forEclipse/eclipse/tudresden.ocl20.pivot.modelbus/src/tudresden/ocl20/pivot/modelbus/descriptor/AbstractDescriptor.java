/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Matthias Braeuer (braeuer.matthias@web.de).            *
 * All rights reserved.                                                      *
 *                                                                           *
 * This work was done as a project at the Chair for Software Technology,     *
 * Dresden University Of Technology, Germany (http://st.inf.tu-dresden.de).  *
 * It is understood that any modification not identified as such is not      *
 * covered by the preceding statement.                                       *
 *                                                                           *
 * This work is free software; you can redistribute it and/or modify it      *
 * under the terms of the GNU Library General Public License as published    *
 * by the Free Software Foundation; either version 2 of the License, or      *
 * (at your option) any later version.                                       *
 *                                                                           *
 * This work is distributed in the hope that it will be useful, but WITHOUT  *
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or     *
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Library General Public     *
 * License for more details.                                                 *
 *                                                                           *
 * You should have received a copy of the GNU Library General Public License *
 * along with this library; if not, you can view it online at                *
 * http://www.fsf.org/licensing/licenses/gpl.html.                           *
 *                                                                           *
 * To submit a bug report, send a comment, or get the latest news on this    *
 * project, please visit the website: http://dresden-ocl.sourceforge.net.    *
 * For more information on OCL and related projects visit the OCL Portal:    *
 * http://st.inf.tu-dresden.de/ocl                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * $Id$
 */
package tudresden.ocl20.pivot.modelbus.descriptor;

import javax.management.Descriptor;

import org.apache.commons.lang.IllegalClassException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import tudresden.ocl20.pivot.modelbus.ModelBusPlugin;

/**
 * <p>
 * This is a simple base class for classes realizing a descriptor for an
 * extension point. It provides methods to load strings and icon resources as
 * well as instantiate executable extensions specified in an
 * {@link IConfigurationElement}. This is a generally reusable class that could
 * also be located outside of this plug-in.
 * </p>
 * 
 * @author Matthias Braeuer
 */
public abstract class AbstractDescriptor implements IDescriptor {

	/** a {@link Logger} for this class. */
	private static final Logger logger =
			ModelBusPlugin.getLogger(AbstractDescriptor.class);

	/** The id of the extension. */
	private String id;

	/** The configuration element that is the source of this descriptor. */
	private IConfigurationElement configElement;

	/**
	 * <p>
	 * Creates a new {@link Descriptor} and is supposed to be called by
	 * subclasses.
	 * </p>
	 * 
	 * @param configElement
	 *          The {@link IllegalClassException} this {@link AbstractDescriptor}
	 *          shall be created for.
	 * @throws IllegalArgumentException
	 *           Throw if <code>configElement</code> is <code>null</code>.
	 */
	protected AbstractDescriptor(IConfigurationElement configElement) {

		if (configElement == null) {
			throw new IllegalArgumentException("The configuration element was null."); //$NON-NLS-1$
		}
		// no else.

		this.configElement = configElement;
		id = getAttribute(ATT_ID, false);
	}

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.pivot.modelbus.internal.descriptor.IDescriptor#getId()
	 */
	public String getId() {

		return this.id;
	}

	/**
	 * <p>
	 * This implementation simply delegates to {@link #getId()}.
	 * </p>
	 * 
	 * @see org.eclipse.ui.IPluginContribution#getLocalId()
	 */
	public String getLocalId() {

		return this.getId();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IPluginContribution#getPluginId()
	 */
	public String getPluginId() {

		return this.configElement.getContributor().getName();
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.modelbus.internal.descriptor.IDescriptor#
	 * getDeclaringExtension()
	 */
	public IExtension getDeclaringExtension() {

		return this.configElement.getDeclaringExtension();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append(
				"id", id).toString(); //$NON-NLS-1$
	}

	/**
	 * <p>
	 * Helper method for sub-classes to check whether an attribute has been
	 * assigned a value. This is useful for validating attributes that contain a
	 * java class name, for instance.
	 * </p>
	 * 
	 * @param attributeName
	 *          The name of the attribute.
	 * 
	 * @throws InvalidDescriptorException
	 *           If the value is empty.
	 */
	protected void checkAttribute(String attributeName) {

		if (logger.isDebugEnabled()) {
			logger
					.debug("checkAttribute(attributeName=" + attributeName + ") - enter"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		// no else.

		// simple use the checks implemented in #getAttribute()
		getAttribute(attributeName, true);

		if (logger.isDebugEnabled()) {
			logger.debug("checkAttribute() - exit"); //$NON-NLS-1$
		}
		// no else.
	}

	/**
	 * <p>
	 * Creates an instance for the specified attribute. This must be an attribute
	 * of type 'java' that defines a class.
	 * </p>
	 * 
	 * @param attributeName
	 *          The name of the attribute.
	 * @param type
	 *          The expected type of the executable extension.
	 * 
	 * @return The instantiated object.
	 * 
	 * @throws InvalidDescriptorException
	 *           If the extension cannot be instantiated.
	 */
	protected <T> T createInstance(String attributeName, Class<T> type) {

		if (logger.isDebugEnabled()) {
			logger.debug("createInstance(attributeName=" + attributeName + //$NON-NLS-1$
					", type=" + type + ") - enter"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		// no else.

		Object instance = null;

		try {
			instance = configElement.createExecutableExtension(attributeName);
		}

		catch (CoreException e) {
			throwInvalidDescriptorException(attributeName,
					"Failed to instantiate an executable extension.", e); //$NON-NLS-1$
		}

		// check if the created instance has the correct type
		if (!type.isInstance(instance)) {
			throwInvalidDescriptorException(attributeName,
					"Specified class does not derive from " //$NON-NLS-1$
							+ type.getCanonicalName() + ".", null); //$NON-NLS-1$
		}
		// no else.

		T returnT = type.cast(instance);

		if (logger.isDebugEnabled()) {
			logger.debug("createInstance() - exit - return value=" + returnT); //$NON-NLS-1$
		}

		return returnT;
	}

	/**
	 * <p>
	 * Helper method that returns the value of an attribute. Throws an
	 * {@link InvalidDescriptorException} if the attribute is empty and required.
	 * </p>
	 * 
	 * @param attributeName
	 *          The name of the extension point attribute.
	 * @param required
	 *          Whether the attribute should have a non-empty value.
	 * 
	 * @throws InvalidDescriptorException
	 *           If the value of the attribute is invalid.
	 */
	protected String getAttribute(String attributeName, boolean required) {

		if (logger.isDebugEnabled()) {
			logger
					.debug("getAttribute(attributeName=" + attributeName + ", required=" + required //$NON-NLS-1$ //$NON-NLS-2$
							+ ") - enter"); //$NON-NLS-1$
		}
		// no else.

		String value = configElement.getAttribute(attributeName);

		if (required && StringUtils.isEmpty(value)) {
			throwInvalidDescriptorException(attributeName,
					"Value of attribute was empty.", null); //$NON-NLS-1$
		}
		// no else.

		if (logger.isDebugEnabled()) {
			logger.debug("getAttribute() - exit - return value=" + value); //$NON-NLS-1$
		}
		// no else.

		return value;
	}

	/**
	 * <p>
	 * Helper method for subclasses that returns an icon resource for the given
	 * attribute name. If no icon can be found, a default icon is returned.
	 * </p>
	 */
	protected ImageDescriptor getImageDescriptor(String attributeName) {

		if (logger.isDebugEnabled()) {
			logger.debug("getIcon(attributeName=" + attributeName + ") - enter"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		String iconName;
		ImageDescriptor icon = null;

		// get the value of the icon attribute
		iconName = configElement.getAttribute(attributeName);

		// try to get the icon
		if (iconName != null) {
			icon =
					AbstractUIPlugin.imageDescriptorFromPlugin(getDeclaringExtension()
							.getContributor().getName(), iconName);
		}

		// If no icon was found use the error icon
		if (icon == null) {
			logger
					.warn("No icon resource found for attribute " + attributeName + " in extension " + id); //$NON-NLS-1$ //$NON-NLS-2$
			icon = ImageDescriptor.getMissingImageDescriptor();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getIcon() - exit - return value=" + icon); //$NON-NLS-1$
		}

		return icon;
	}

	/**
	 * <p>
	 * Helper method that throws an exception with some additional information.
	 * </p>
	 * 
	 * @param propertyName
	 *          The name of the property causing the error.
	 * @param message
	 *          An optional message.
	 * @param cause
	 *          An optional cause.
	 */
	protected void throwInvalidDescriptorException(String propertyName,
			String message, Exception cause) {

		StringBuilder errorMsg = new StringBuilder();

		errorMsg.append("The value of attribute '").append(propertyName).append( //$NON-NLS-1$
				"' defined in element '").append(id)
				.append("' of extension point '").append( //$NON-NLS-1$ //$NON-NLS-2$
						getDeclaringExtension().getExtensionPointUniqueIdentifier())
				.append("' in plugin '") //$NON-NLS-1$
				.append(getDeclaringExtension().getContributor().getName()).append(
						"' is invalid."); //$NON-NLS-1$

		if (message != null) {
			errorMsg.append(" ").append(message); //$NON-NLS-1$
		}

		throw new InvalidDescriptorException(errorMsg.toString(), cause);
	}
}