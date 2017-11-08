/*
 * Frame.java
 *
 * Created on 10 ao�t 2003, 19:23
 */

import java.util.*;

/**
 *
 * @author  Rodrigo
 */
public class JSmoothPropertiesDisplayer extends java.awt.Frame
{

    private String[] m_args;
	/** Creates new form Frame */
	public JSmoothPropertiesDisplayer(String[] args)
    {
	m_args = args;
		initComponents();
		displayInformation();
	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        label1 = new java.awt.Label();
        m_text = new java.awt.TextArea();
        m_buttonClose = new java.awt.Button();

        setLayout(new java.awt.GridBagLayout());

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
/*
        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 0, 18));
        label1.setText("JSmooth Sample Program");
        */
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(label1, gridBagConstraints);

        m_text.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(m_text, gridBagConstraints);

        m_buttonClose.setLabel("Close");
        m_buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(m_buttonClose, gridBagConstraints);

	java.awt.Button reboot = new java.awt.Button("JNI Tests");
        add(reboot, gridBagConstraints);
        reboot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
		try {
		    java.io.File f = new java.io.File("Z:/test");
		    System.out.println(f.getAbsoluteFile().toString());
		    System.out.println(f.getAbsoluteFile().getCanonicalPath().toString());
		    System.out.println("JNI Availability : " + jsmooth.Native.isAvailable());

		    if (jsmooth.Native.isAvailable())
			{

			    jsmooth.DriveInfo di = jsmooth.Native.getDriveInfo(f);
			    if (di.getDriveType() == jsmooth.DriveInfo.DRIVE_REMOVABLE)
				{
				    // This file is on a removeable drive !
				}
			    if (di.getFreeSpaceForUser() < (1024*1024*64))
				{
				    // there are less than 64MB free for the
				    // user on this drive !
				}

			    System.out.println("DriveInfo: " + di + " = " + di.toString());

			    System.out.println("path: " + jsmooth.Native.getExecutablePath());
			    System.out.println("filename: " + jsmooth.Native.getExecutableName());
// 			    jsmooth.Native.shellExecute(jsmooth.Native.SHELLEXECUTE_OPEN, 
// 							"service.log", 	null, null, 
// 							jsmooth.Native.SW_SHOWNORMAL);
// 			    jsmooth.Native.shellExecute(jsmooth.Native.SHELLEXECUTE_FIND, 
// 							"c:\\TEMP", 	null, null, 
// 							jsmooth.Native.SW_SHOWNORMAL);
// 			    jsmooth.Native.shellExecute(jsmooth.Native.SHELLEXECUTE_EXPLORE, 
// 							"z:\\", 	null, null, 
// 							jsmooth.Native.SW_SHOWNORMAL);

			    //			    System.out.println("RES: " + jsmooth.Native.exitWindows(jsmooth.Native.EXITWINDOWS_REBOOT | jsmooth.Native.EXITWINDOWS_FORCE ));
			}
		} catch (Exception e)
		    {
			e.printStackTrace();
		    }
            }
        });

        pack();
    }//GEN-END:initComponents

	private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonCloseActionPerformed
	{//GEN-HEADEREND:event_buttonCloseActionPerformed
		// Add your handling code here:
		System.exit(0);
	}//GEN-LAST:event_buttonCloseActionPerformed
	
	/** Exit the Application */
	private void exitForm(java.awt.event.WindowEvent evt)//GEN-FIRST:event_exitForm
	{
		System.exit(87);
	}//GEN-LAST:event_exitForm
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) throws Exception
	{
	    new JSmoothPropertiesDisplayer(args).setVisible(true);
	    //	    Thread.currentThread().sleep(1000*60);
	}

	private void displayInformation()
	{
		StringBuffer out = new StringBuffer();
		out.append("-- Sample --\n\n");

		out.append("Current Directory: " + new java.io.File(".").getAbsolutePath() + "\n");

		out.append("Arguments passed on the command line: " + m_args.length + " \n");
		for (int i=0; i<m_args.length; i++)
		    {
			out.append("" + i + ". " + m_args[i]);
			out.append("\n");
		    }
		out.append("\n");

		out.append("Free Heap Memory: " + Runtime.getRuntime().freeMemory() + " bytes\n");
		//		out.append("Max Heap Memory: " + Runtime.getRuntime().maxMemory() + " bytes\n");
		out.append("Total Heap Memory: " + Runtime.getRuntime().totalMemory() + " bytes\n");
		out.append("\n");

		out.append("System Properties:\n\n");
		Properties props = System.getProperties();
		for (Enumeration e = props.propertyNames(); e.hasMoreElements(); )
		{
			String key = (String)e.nextElement();
			out.append(key);
			out.append(" = ");
			out.append(props.getProperty(key));
			out.append("\n");
		}
		System.out.println(out.toString());
		m_text.setText(out.toString());
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label label1;
    private java.awt.Button m_buttonClose;
    private java.awt.TextArea m_text;
    // End of variables declaration//GEN-END:variables
	
}
