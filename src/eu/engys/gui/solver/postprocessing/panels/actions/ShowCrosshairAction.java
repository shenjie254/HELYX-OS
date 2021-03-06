/*******************************************************************************
 *  |       o                                                                   |
 *  |    o     o       | HELYX-OS: The Open Source GUI for OpenFOAM             |
 *  |   o   O   o      | Copyright (C) 2012-2016 ENGYS                          |
 *  |    o     o       | http://www.engys.com                                   |
 *  |       o          |                                                        |
 *  |---------------------------------------------------------------------------|
 *  |   License                                                                 |
 *  |   This file is part of HELYX-OS.                                          |
 *  |                                                                           |
 *  |   HELYX-OS is free software; you can redistribute it and/or modify it     |
 *  |   under the terms of the GNU General Public License as published by the   |
 *  |   Free Software Foundation; either version 2 of the License, or (at your  |
 *  |   option) any later version.                                              |
 *  |                                                                           |
 *  |   HELYX-OS is distributed in the hope that it will be useful, but WITHOUT |
 *  |   ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or   |
 *  |   FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License   |
 *  |   for more details.                                                       |
 *  |                                                                           |
 *  |   You should have received a copy of the GNU General Public License       |
 *  |   along with HELYX-OS; if not, write to the Free Software Foundation,     |
 *  |   Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA            |
 *******************************************************************************/
package eu.engys.gui.solver.postprocessing.panels.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Icon;

import eu.engys.gui.events.EventManager;
import eu.engys.gui.solver.postprocessing.panels.utils.events.ShowCrosshairEvent;
import eu.engys.util.ui.ResourcesUtil;

public class ShowCrosshairAction extends AbstractAction {

    private static final Icon CROSSHAIR_ICON = ResourcesUtil.getIcon("crosshair.icon");

    public ShowCrosshairAction() {
        super("", CROSSHAIR_ICON);
        putValue(SHORT_DESCRIPTION, "Show a crosshair over the chart");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean visible = ((AbstractButton) e.getSource()).isSelected();
        EventManager.triggerEvent(this, new ShowCrosshairEvent(visible));
    }
}