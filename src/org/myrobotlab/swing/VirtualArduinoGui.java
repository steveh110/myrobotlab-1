/**
 *                    
 * @author greg (at) myrobotlab.org
 *  
 * This file is part of MyRobotLab (http://myrobotlab.org).
 *
 * MyRobotLab is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version (subject to the "Classpath" exception
 * as provided in the LICENSE.txt file that accompanied this code).
 *
 * MyRobotLab is distributed in the hope that it will be useful or fun,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * All libraries in thirdParty bundle are subject to their own license
 * requirements - please refer to http://myrobotlab.org/libraries for 
 * details.
 * 
 * Enjoy !
 * 
 * */

package org.myrobotlab.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

import org.myrobotlab.service.Runtime;
import org.myrobotlab.service.SwingGui;
import org.myrobotlab.service.VirtualArduino;
import org.myrobotlab.swing.widget.PortGui;

// FIXME - add stop watch capabilities
public class VirtualArduinoGui extends ServiceGui implements ActionListener {
  static final long serialVersionUID = 1L;
  PortGui portgui;
  JButton button = new JButton("button");
 
  public VirtualArduinoGui(final String boundServiceName, final SwingGui myService, final JTabbedPane tabs) {
    super(boundServiceName, myService, tabs);  
    VirtualArduino virtual = (VirtualArduino)Runtime.getService(boundServiceName);
    // Peers.getPeerKey(boundServiceName, reservedKey);
    // getPeerName - needs to get from immutable local copy of config & know about context & gateway :(
    // String uartName = virtual.getPeerName("uart"); // getPeerName - needs to know if local or not
    // SerialDevice serial = virtual.getSerial();
    portgui = new PortGui(virtual.getPeerName("uart"), myService, tabs);
    addTop(portgui.getDisplay());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();
  }

  @Override
  public void subscribeGui() {
  }

  @Override
  public void unsubscribeGui() {
  }

  public void onState(final VirtualArduino c) {
  }


}
