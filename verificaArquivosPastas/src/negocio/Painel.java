package negocio;

import javax.swing.JOptionPane;

public class Painel extends javax.swing.JFrame {
                 
    private javax.swing.JButton jButton1; 
	
    public Painel() {
        initComponents();
    }

    private void initComponents() {

        jButton1 = new javax.swing.JButton(); 

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Desligar Aplicação");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jButton1)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jButton1)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        pack();
    }                      

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //para a Aplicação ao apertar no botão
    	System.exit(0);
    }  
 
    public void showCustomAlert(String message){

        JOptionPane optionPane = new JOptionPane(message);
        javax.swing.JDialog dialog = optionPane.createDialog(this, "Aviso");
        java.awt.Toolkit.getDefaultToolkit().beep();
        dialog.setAlwaysOnTop(true);    
        dialog.setVisible(true);
        //coloca a janela na frente após fechar o aviso
        this.toFront();

    }

    void carregaPainel(){
    	try {
	        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	            if ("Nimbus".equals(info.getName())) {
	                javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                break;
	            }
	        }
	    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException app) {
	        java.util.logging.Logger.getLogger(Painel.class.getName()).log(java.util.logging.Level.SEVERE, null, app);
	    } 
	    java.awt.EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            new Painel().setVisible(true);
	        }
	    });
    }
}
