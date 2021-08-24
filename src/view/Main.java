package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {
	public static void main(String[] args) {
		int opc = 0;
		do {
		KillController killer = new KillController();
		String os = killer.getOS();
		killer.listProcess(os);
		int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do PID:"));
		killer.killpid(os, pid);
		String name = JOptionPane.showInputDialog("Digite o nome do Processo");
		killer.killpidbyname(os, name);
		opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite 1 para finalizar, ou qualquer numero para continuar: "));
		}while (opc != 1);
	}
}