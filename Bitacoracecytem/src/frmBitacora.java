import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.JTextField;
import javax.swing.JLabel;


import java.awt.Font;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmBitacora {

	private JFrame frmBitacora;
	private JTextField tfNoControl;
	private JTextField tfNombre;
	private JTextField tfHoraEntrada;
	private JTextField tfHoraSalida;
	private JTextField tfFecha;
	
	DataBitacora conexion= new DataBitacora();
	BitacoraCecytem var=new BitacoraCecytem();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBitacora window = new frmBitacora();
					window.frmBitacora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmBitacora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBitacora = new JFrame();
		frmBitacora.setTitle("Alumno");
		frmBitacora.setBounds(100, 100, 602, 651);
		frmBitacora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBitacora.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lbNoControl = new JLabel("Número de Control");
		lbNoControl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbNoControl, "6, 4");
		
		tfNoControl = new JTextField();
		tfNoControl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfNoControl.getText().length()>=10) {
					e.consume();
				}
			}
		});
		frmBitacora.getContentPane().add(tfNoControl, "10, 4, fill, default");
		tfNoControl.setColumns(10);
		
		JLabel lbNombreInstitución = new JLabel("Nombre de la institución");
		lbNombreInstitución.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbNombreInstitución, "6, 8, 4, 1");
		
		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfNombre.getText().length()>=100) {
					e.consume();
				}
			}
		});
		frmBitacora.getContentPane().add(tfNombre, "10, 8, fill, default");
		tfNombre.setColumns(10);
		
		JLabel lbHoraEntrada = new JLabel("Hora de entrada");
		lbHoraEntrada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbHoraEntrada, "6, 12");
		
		tfHoraEntrada = new JTextField();
		tfHoraEntrada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfHoraEntrada.getText().length()>=5) {
					e.consume();
				}
			}
		});
		frmBitacora.getContentPane().add(tfHoraEntrada, "10, 12, fill, default");
		tfHoraEntrada.setColumns(10);
		
		JLabel lbHoraSalida = new JLabel("Hora de salida");
		lbHoraSalida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbHoraSalida, "6, 16");
		
		tfHoraSalida = new JTextField();
		tfHoraSalida.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfHoraSalida.getText().length()>=5) {
					e.consume();
				}
			}
		});
		frmBitacora.getContentPane().add(tfHoraSalida, "10, 16, fill, default");
		tfHoraSalida.setColumns(10);
		
		JLabel lbFecha = new JLabel("Fecha");
		lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbFecha, "6, 20");
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BitacoraCecytem.noControl=tfNoControl.getText();
				BitacoraCecytem.nombrePlantel=tfNombre.getText();
				BitacoraCecytem.horaEntrada=tfHoraEntrada.getText();
				BitacoraCecytem.horaSalida=tfHoraSalida.getText();
				BitacoraCecytem.fecha=tfFecha.getText();
			    conexion.registrarAlumno();
				limpiar();
			}
		});
		
		tfFecha = new JTextField();
		tfFecha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfFecha.getText().length()>=10) {
					e.consume();
				}
			}
		});
		frmBitacora.getContentPane().add(tfFecha, "10, 20, fill, default");
		tfFecha.setColumns(10);
		frmBitacora.getContentPane().add(btnRegistrar, "6, 24");
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BitacoraCecytem.noControl=tfNoControl.getText();
				BitacoraCecytem.nombrePlantel=tfNombre.getText();
				BitacoraCecytem.horaEntrada=tfHoraEntrada.getText();
				BitacoraCecytem.horaSalida=tfHoraSalida.getText();
				BitacoraCecytem.fecha=tfFecha.getText();
				conexion.actualizarAlumno();
				limpiar();
			}
		});
		frmBitacora.getContentPane().add(btnActualizar, "10, 24");
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion.eliminarAlumno();
				limpiar();

			}
		});
		frmBitacora.getContentPane().add(btnBaja, "14, 24");
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(btnSalir, "18, 24");
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion.consultarAlumno();
				tfNoControl.setText(BitacoraCecytem.noControl);
				tfNombre.setText(BitacoraCecytem.nombrePlantel);
				tfHoraEntrada.setText(BitacoraCecytem.horaEntrada);
				tfHoraSalida.setText(BitacoraCecytem.horaSalida);
				tfFecha.setText(BitacoraCecytem.fecha);
			}
		});
		frmBitacora.getContentPane().add(btnConsultar, "22, 24");
		
		
	}
	public void limpiar() {
		tfNoControl.setText("");
		tfNombre.setText("");
		tfHoraEntrada.setText("");
		tfHoraSalida.setText("");
		tfFecha.setText("");
		BitacoraCecytem.noControl="";
		BitacoraCecytem.nombrePlantel="";
		BitacoraCecytem.horaEntrada="";
		BitacoraCecytem.horaSalida="";
		BitacoraCecytem.fecha="";
		}
}
