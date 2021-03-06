/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.chart.reportitem;

import org.eclipse.birt.chart.reportitem.i18n.Messages;
import org.eclipse.birt.report.model.api.DesignElementHandle;
import org.eclipse.birt.report.model.api.extension.IElementCommand;

/**
 * ChartSimplePropertyCommandImpl
 */
public class ChartSimplePropertyCommandImpl implements IElementCommand
{

	private ChartReportItemImpl item;
	private Object oldValue;
	private Object newValue;
	private DesignElementHandle handle;
	private String propertyName;

	/**
	 * @param newChart
	 * @param oldChart
	 * @param impl
	 * 
	 */
	public ChartSimplePropertyCommandImpl( DesignElementHandle handle,
			ChartReportItemImpl impl, String propName, Object newValue,
			Object oldValue )
	{
		this.handle = handle;
		this.item = impl;
		this.propertyName = propName;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.report.model.api.extension.IElementCommand#execute()
	 */
	public void execute( )
	{
		item.basicSetProperty( propertyName, newValue );
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.report.model.api.extension.IElementCommand#undo()
	 */
	public void undo( )
	{
		item.basicSetProperty( propertyName, oldValue );
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.report.model.api.extension.IElementCommand#redo()
	 */
	public void redo( )
	{
		item.basicSetProperty( propertyName, newValue );
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.report.model.api.extension.IElementCommand#canUndo()
	 */
	public boolean canUndo( )
	{
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.report.model.api.extension.IElementCommand#canRedo()
	 */
	public boolean canRedo( )
	{
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.report.model.api.extension.IElementCommand#getLabel()
	 */
	public String getLabel( )
	{
		return Messages.getString( "ChartElementCommandImpl.setProperty." + propertyName ); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.report.model.api.extension.IElementCommand#getElementHandle()
	 */
	public DesignElementHandle getElementHandle( )
	{
		return handle;
	}

}
