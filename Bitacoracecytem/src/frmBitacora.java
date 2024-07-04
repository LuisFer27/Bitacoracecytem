import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import com.github.lgooddatepicker.components.DatePicker;


public class frmBitacora {

	private JFrame frmBitacora;
	private JTextField tfNoControl;
	private JTextField tfNombre;
	//private JTextField tfHoraEntrada;
	//private JTextField tfHoraSalida;
	//private JTextField tfFecha;
	private DateTimeFormatter dateFormatter;
		private TimePicker tpHoraEntrada;
    private TimePicker tpHoraSalida;
    private DatePicker dtFecha;
	DataBitacora conexion= new DataBitacora();
	BitacoraCecytem var=new BitacoraCecytem();


	//private JTable tabAlumno;

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
  //       mostrarDatos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBitacora = new JFrame();
		frmBitacora.setTitle("Alumno");
		frmBitacora.setBounds(100, 100, 754, 651);
		frmBitacora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBitacora.getContentPane().setLayout(null);
		
		JLabel lbNoControl = new JLabel("Número de Control");
		lbNoControl.setBounds(42, 38, 98, 15);
		lbNoControl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbNoControl);
		
		tfNoControl = new JTextField();
		tfNoControl.setBounds(171, 36, 96, 19);
		tfNoControl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfNoControl.getText().length()>=10) {
					e.consume();
				}
			}
		});
		frmBitacora.getContentPane().add(tfNoControl);
		tfNoControl.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(171, 101, 96, 19);
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfNombre.getText().length()>=100) {
					e.consume();
				}
			}
		});
		
		JLabel lbNombreInstitución = new JLabel("Nombre de la institución");
		lbNombreInstitución.setBounds(42, 103, 124, 15);
		lbNombreInstitución.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbNombreInstitución);
		frmBitacora.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lbHoraEntrada = new JLabel("Hora de entrada");
		lbHoraEntrada.setBounds(42, 183, 86, 15);
		lbHoraEntrada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbHoraEntrada);
		
		//tfHoraEntrada = new JTextField();
		//tfHoraEntrada.setBounds(171, 181, 96, 19);
		//tfHoraEntrada.addKeyListener(new KeyAdapter() {
		//	@Override
		//	public void keyTyped(KeyEvent e) {
		//		if(tfHoraEntrada.getText().length()>=5) {
		//			e.consume();
		//		}
		//	}
		//});
		//frmBitacora.getContentPane().add(tfHoraEntrada);
		//tfHoraEntrada.setColumns(10);
		//
		//tabAlumno = new JTable();
		//tabAlumno.setColumnSelectionAllowed(true);
		//tabAlumno.setCellSelectionEnabled(true);
		//tabAlumno.setShowHorizontalLines(true);
		//tabAlumno.setShowVerticalLines(true);
		//tabAlumno.setModel(new DefaultTableModel(
		//		new Object[][] {},
		//		
		//		new String[] {"ID", "Número de Control", "Nombre", "Hora de Entrada", "Hora de Salida", "Fecha"}
		//	));
		//	tabAlumno.setBounds(313, 60, 379, 327);
		//	tabAlumno.addMouseListener(new MouseAdapter() {
		//		@Override
		//		public void mouseClicked(MouseEvent e) {
		//			int filaSeleccionada = tabAlumno.getSelectedRow();
		//			if (filaSeleccionada != -1) {
		//				DefaultTableModel model = (DefaultTableModel) tabAlumno.getModel();
		//				tfNoControl.setText(model.getValueAt(filaSeleccionada, 1).toString());
		//				tfNombre.setText(model.getValueAt(filaSeleccionada, 2).toString());
		//	//			tfHoraEntrada.setText(model.getValueAt(filaSeleccionada, 3).toString());
			//			tfHoraSalida.setText(model.getValueAt(filaSeleccionada, 4).toString());
			//			tfFecha.setText(model.getValueAt(filaSeleccionada, 5).toString());
			//		}
			//	//}
			//});
			//frmBitacora.getContentPane().add(tabAlumno);
		//tabAlumno.setBounds(313, 60, 252, 327);
		//frmBitacora.getContentPane().add(tabAlumno);
		
		
		
		
		
		
		JLabel lbHoraSalida = new JLabel("Hora de salida");
		lbHoraSalida.setBounds(42, 266, 74, 35);
		lbHoraSalida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbHoraSalida);
		
		//tfHoraSalida = new JTextField();
		//tfHoraSalida.setBounds(171, 284, 96, 19);
		//tfHoraSalida.addKeyListener(new KeyAdapter() {
		//	@Override
		//	public void keyTyped(KeyEvent e) {
		//		if(tfHoraSalida.getText().length()>=5) {
		//			e.consume();
		//		}
		//	}
		//});
		//frmBitacora.getContentPane().add(tfHoraSalida);
		//tfHoraSalida.setColumns(10);
		
		JLabel lbFecha = new JLabel("Fecha");
		lbFecha.setBounds(42, 370, 124, 15);
		lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbFecha);
		
	//	tfFecha = new JTextField();
	//	tfFecha.setBounds(171, 368, 96, 19);
	//	tfFecha.addKeyListener(new KeyAdapter() {
	//		@Override
	//		public void keyTyped(KeyEvent e) {
	//			if(tfFecha.getText().length()>=10) {
	//				e.consume();
	//			}
	//		}
	//	});
	//	frmBitacora.getContentPane().add(tfFecha);
	//	tfFecha.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(42, 452, 86, 23);
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BitacoraCecytem.noControl=tfNoControl.getText();
				BitacoraCecytem.nombrePlantel=tfNombre.getText();
			       //BitacoraCecytem.horaEntrada = getFormattedTime(tpHoraEntrada);
		            //BitacoraCecytem.horaSalida = getFormattedTime(tpHoraSalida);
				  try {
			            // Verifica que timePicker no sea null antes de usarlo
					  String horaString;
			            if (tpHoraEntrada != null) {
			                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
			                horaString = timeFormat.format(tpHoraEntrada.getTime());
			            } else {
			                // Manejo cuando tpHoraEntrada es null
			            	 horaString = "00:00"; // O la fecha que desees para manejar nulos
			            }
                        BitacoraCecytem.horaEntrada = horaString;
                        
                        String horaSalida;
			            if (tpHoraSalida != null) {
			            	   SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
				                horaSalida = timeFormat.format(tpHoraSalida.getTime());
			            } else {
			                // Manejo cuando tpHoraSalida es null
			                horaSalida = "00:00"; // Valor por defecto o mensaje de error
			            }
			            BitacoraCecytem.horaSalida = horaSalida;
			            String fechaString;
			            if (dtFecha != null && dtFecha.getDate() != null) {
			                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			                fechaString = dateFormat.format(dtFecha.getDate());
			            } else {
			                // Manejo cuando dtFecha es null o dtFecha.getDate() es null
			            	 fechaString = "0000-00-00";
			            }
			         // Asignar a BitacoraCecytem.fecha
			            BitacoraCecytem.fecha = fechaString;
			           
			            conexion.registrarAlumno();
			            limpiar();
			        } catch (NullPointerException ex) {
			            // Manejo de la excepción
			            ex.printStackTrace();
			            // Otro manejo según necesidad
			        }
				//conexion.registrarAlumno();
				//if (conexion.registrarAlumno()) {
				//	 mostrarDatos();
		        //}
			   // limpiar();
		
			}
		});
		frmBitacora.getContentPane().add(btnRegistrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(156, 452, 96, 23);
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BitacoraCecytem.noControl=tfNoControl.getText();
				BitacoraCecytem.nombrePlantel=tfNombre.getText();
				  try {
			            // Verifica que timePicker no sea null antes de usarlo
					  String horaString;
			            if (tpHoraEntrada != null) {
			                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
			                horaString = timeFormat.format(tpHoraEntrada.getTime());
			            } else {
			                // Manejo cuando tpHoraEntrada es null
			            	 horaString = "00:00"; // O la fecha que desees para manejar nulos
			            }
                      BitacoraCecytem.horaEntrada = horaString;
                      
                      String horaSalida;
			            if (tpHoraSalida != null) {
			            	   SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
				                horaSalida = timeFormat.format(tpHoraSalida.getTime());
			            } else {
			                // Manejo cuando tpHoraSalida es null
			                horaSalida = "00:00"; // Valor por defecto o mensaje de error
			            }
			            BitacoraCecytem.horaSalida = horaSalida;
			            String fechaString;
			            if (dtFecha != null && dtFecha.getDate() != null) {
			                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			                fechaString = dateFormat.format(dtFecha.getDate());
			            } else {
			                // Manejo cuando dtFecha es null o dtFecha.getDate() es null
			            	 fechaString = "0000-00-00";
			            }
			         // Asignar a BitacoraCecytem.fecha
			            BitacoraCecytem.fecha = fechaString;
			           
			            conexion.actualizarAlumno();
			            limpiar();
			        } catch (NullPointerException ex) {
			            // Manejo de la excepción
			            ex.printStackTrace();
			            // Otro manejo según necesidad
			        }
			      // BitacoraCecytem.horaEntrada = getFormattedTime(tpHoraEntrada);
		            //BitacoraCecytem.horaSalida = getFormattedTime(tpHoraSalida);
				//BitacoraCecytem.fecha=dtFecha.getDate().toString();
				//conexion.actualizarAlumno();
			    //if (conexion.actualizarAlumno()) {
			   // 	 mostrarDatos();
		        //}
				//limpiar();
				//mostrarDatos();
			}
		});
		frmBitacora.getContentPane().add(btnActualizar);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setBounds(262, 452, 74, 23);
		btnBaja.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        //if (conexion.eliminarAlumno()) {
		       // 	mostrarDatos();
		        //}
				conexion.eliminarAlumno();
		        limpiar();
              
			}
		});
		frmBitacora.getContentPane().add(btnBaja);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(360, 452, 61, 23);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frmBitacora.getContentPane().add(btnSalir);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(449, 452, 98, 23);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion.consultarAlumno();
				tfNoControl.setText(BitacoraCecytem.noControl);
				tfNombre.setText(BitacoraCecytem.nombrePlantel);
				tpHoraEntrada.setText(BitacoraCecytem.horaEntrada != null ? BitacoraCecytem.horaEntrada : "");
				tpHoraSalida.setText(BitacoraCecytem.horaSalida != null ? BitacoraCecytem.horaSalida : "");
				dtFecha.setText(BitacoraCecytem.fecha != null ? BitacoraCecytem.fecha : "");
			}
		});
		frmBitacora.getContentPane().add(btnConsultar);
		
		TimePicker tpHoraEntrada = new TimePicker();
		tpHoraEntrada.setBounds(176, 179, 91, 23);
		  tpHoraEntrada.setTime(LocalTime.now());
		frmBitacora.getContentPane().add(tpHoraEntrada);
		
	     // Definir un formateador de fecha personalizado
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		TimePicker tpHoraSalida = new TimePicker();
		tpHoraSalida.setBounds(171, 266, 91, 23);
		  tpHoraSalida.setTime(LocalTime.now().plusHours(1));
		frmBitacora.getContentPane().add(tpHoraSalida);
		
		DatePicker dtFecha = new DatePicker();
        // Obtener la fecha actual y formatearla
        LocalDate fechaHoy = LocalDate.now();
        String fechaFormateada = fechaHoy.format(dateFormatter);

        // Configurar el texto inicial del DatePicker
        dtFecha.setText(fechaFormateada);
		dtFecha.setBounds(162, 367, 174, 22);

		frmBitacora.getContentPane().add(dtFecha);
		// Manejar cambios de fecha para actualizar el valor interno del DatePicker
        dtFecha.addDateChangeListener(new DateChangeListener() {
            @Override
            public void dateChanged(DateChangeEvent event) {
                // Obtener la fecha seleccionada en el formato deseado
                LocalDate fechaSeleccionada = event.getNewDate();
                String fechaFormateada = fechaSeleccionada.format(dateFormatter);

                // Actualizar el texto del DatePicker con el formato deseado
                dtFecha.setText(fechaFormateada);
            }
        });

	}
	

	//private void mostrarDatos() {
	//    List<BitacoraCecytem> alumnos = conexion.obtenerAlumnos();
	//    DefaultTableModel model = (DefaultTableModel) tabAlumno.getModel();
	//    model.setRowCount(0); // Limpiar tabla antes de cargar datos
//
	//    Set<String> idsVistos = new HashSet<>(); // Utilizamos un set para almacenar IDs ya vistos
//
	 //   for (BitacoraCecytem alumno : alumnos) {
	 //       if (!idsVistos.contains(alumno.id)) { // Si el ID no está en el set, agregamos el registro a la tabla
	// //           model.addRow(new Object[]{alumno.id, alumno.noControl, alumno.nombrePlantel, alumno.horaEntrada, alumno.horaSalida, alumno.fecha});
	//            idsVistos.add(alumno.id); // Agregamos el ID al set de IDs vistos
	//        }
	//    }
	//}

	public void limpiar() {
	    // Limpiar campos de texto
	    tfNoControl.setText("");
	    tfNombre.setText("");
	    //tfHoraEntrada.setText("");
	    //tfHoraSalida.setText("");
	   // tfFecha.setText("");

	    // Limpiar TimePickers
        if (tpHoraEntrada != null) {
            tpHoraEntrada.clear();
        }
        if (tpHoraSalida != null) {
            tpHoraSalida.clear();
        }

        // Limpiar DatePicker
        if (dtFecha != null) {
            dtFecha.setDateToToday(); // O establecer a null si no deseas una fecha por defecto
        }

	    // Resetear variables estáticas en la clase BitacoraCecytem
	    BitacoraCecytem.noControl = "";
	    BitacoraCecytem.nombrePlantel = "";
	    BitacoraCecytem.horaEntrada = "";
	    BitacoraCecytem.horaSalida = "";
	    BitacoraCecytem.fecha = "";
	}
	private String getFormattedTime(TimePicker timePicker) {
	    LocalTime time = timePicker.getTime();
	    if (time != null) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	        return time.format(formatter);
	    } else {
	        // Maneja el caso de tiempo nulo, quizá retornando una hora por defecto o un mensaje de error.
	        return "00:00:00";
	    }
	}
}
