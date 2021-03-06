package com.jdevbook.chap7;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import oracle.jdeveloper.layout.*;


public class PanelCourseView1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelCourseView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigationbar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  CourseView1

  private JTable tableCourseView1 = new JTable();
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelCourseView1()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Layout definition for this panel
    dataPanel.setLayout(gridLayout);
    dataPanel.setMinimumSize(new Dimension(100, 100));
    this.setLayout(borderLayout);
    // Code support for view object:  CourseView1
    tableCourseView1.setModel((TableModel)panelBinding.bindUIControl("CourseView1", tableCourseView1));
    scroller.getViewport().add(tableCourseView1, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "CourseView1", null, "CourseView1Iter"));
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.SOUTH);
    add(dataPanel, BorderLayout.CENTER);


  }

  public static void main(String [] args)
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception exemp)
    {
      exemp.printStackTrace();
    }

    PanelCourseView1 panel = new PanelCourseView1();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "com_jdevbook_chap7_model_AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300)));
    panel.revalidate();
  }

  /**
   * 
   *  JClientPanel implementation
   */
  public JUPanelBinding getPanelBinding()
  {
    return panelBinding;
  }

  public void setBindingContext(BindingContext bindCtx)
  {
    if (panelBinding.getPanel() == null)
    {
      panelBinding = panelBinding.setup(bindCtx, this);
      try
      {
        jbInit();
        panelBinding.refreshControl();
      }
      catch(Exception ex)
      {
        panelBinding.reportException(ex);
      }

    }
  }
}