/**
 * Nombre del proyecto:Bitacoracecytem
 * Descripción:Aplicación para llevar un control de registro de alumnos que estan en un área especifica 
 * Fecha:04/07/2024
 * Autor:Luis Fernando Mendez Barrera
 * Versión 1.0.0
 */

//importaciones
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import javax.swing.JTextArea;



// clase frm bitacora en donde se vera la interfaz grafica manejada en spring 
public class frmBitacora {
    //componentes de la aplicación donde se alamcenara la información declarados
	private JFrame frmBitacora;
	private JTextField tfNoControl;
	private TimePicker tpHoraEntrada;
	private TimePicker tpHoraSalida;
	private DatePicker dpFecha;
	private JTextArea taNombre;
	//referncial archivo de conexión a la bd donde se mandara a llamar los apartados 
    DataBitacora conexion= new DataBitacora();
    //referencia al archivo para obtener y configurar los valores dentro de la aplicación 
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
	 * Crea la aplicación y la inicializa con todas la propiedades y clases .
	 */
	public frmBitacora() {
		initialize();
  //       mostrarDatos();
	}

	/**
	 * Initialize inicializa todo el contenido de java swing almacenado en un jframe.
	 */
	private void initialize() {
		frmBitacora = new JFrame();
		//nombre del programa 
		frmBitacora.setTitle("Alumno");
		frmBitacora.setBounds(100, 100, 754, 651);
		frmBitacora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBitacora.getContentPane().setLayout(null);
		//etiqueta número de control en relación con el alúmno 
		JLabel lbNoControl = new JLabel("Número de Control");
		lbNoControl.setBounds(42, 38, 98, 15);
		lbNoControl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbNoControl);
		//campo de texto número de control
		tfNoControl = new JTextField();
		tfNoControl.setBounds(171, 36, 96, 19);
		tfNoControl.addKeyListener(new KeyAdapter() {
			//validación de 10 caracteres
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfNoControl.getText().length()>=10) {
					e.consume();
				}
				char c =e.getKeyChar();
				if(!Character.isLetterOrDigit(c)) {
					e.consume();
				}
				
			}
		});
		frmBitacora.getContentPane().add(tfNoControl);
		tfNoControl.setColumns(10);
		//etiqueta nombre de la institución
		JLabel lbNombreInstitución = new JLabel("Nombre de la institución");
		lbNombreInstitución.setBounds(42, 103, 124, 15);
		lbNombreInstitución.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbNombreInstitución);
		//etiqueta hora de entrada
		JLabel lbHoraEntrada = new JLabel("Hora de entrada");
		lbHoraEntrada.setBounds(42, 183, 86, 15);
		lbHoraEntrada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbHoraEntrada);
        // Inicialización del TimePicker para la hora de entrada
        TimePickerSettings timeSettingsEntrada = new TimePickerSettings();
        timeSettingsEntrada.setFormatForDisplayTime("HH:mm");
        tpHoraEntrada = new TimePicker(timeSettingsEntrada);
        tpHoraEntrada.setBounds(171, 179, 91, 23);
        // Configurar hora actual
        tpHoraEntrada.setTimeToNow();
        frmBitacora.getContentPane().add(tpHoraEntrada);
        // etiqueta hora de salida
		JLabel lbHoraSalida = new JLabel("Hora de salida");
		lbHoraSalida.setBounds(42, 266, 74, 35);
		lbHoraSalida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbHoraSalida);
	      // Inicialización del TimePicker para la hora de salida
        TimePickerSettings timeSettingsSalida = new TimePickerSettings();
        timeSettingsSalida.setFormatForDisplayTime("HH:mm");
        tpHoraSalida = new TimePicker(timeSettingsSalida);
        tpHoraSalida.setBounds(171, 272, 91, 23);
        // Configurar hora una hora después de la actual
        LocalTime horaActual = LocalTime.now();
        LocalTime horaDespues = horaActual.plusHours(1);
        tpHoraSalida.setTime(horaDespues);
        frmBitacora.getContentPane().add(tpHoraSalida);
	
		//etiqueta fecha
		JLabel lbFecha = new JLabel("Fecha");
		lbFecha.setBounds(42, 370, 124, 15);
		lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmBitacora.getContentPane().add(lbFecha);
	     // Inicialización del DatePicker
        DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");
        dpFecha = new DatePicker(dateSettings);
        dpFecha.setBounds(130, 367, 174, 22);
        // Configurar fecha actual
        dpFecha.setDateToToday();
        frmBitacora.getContentPane().add(dpFecha);

		//Botón de registrar
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(42, 452, 86, 23);
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (validarCampos()) {				
			    BitacoraCecytem.noControl=tfNoControl.getText();
				BitacoraCecytem.nombrePlantel=taNombre.getText();
				//horaEntrada
		
			    // Obtener hora de entrada desde el TimePicker
			    String horaEntrada = obtenerHora(tpHoraEntrada);
			    BitacoraCecytem.horaEntrada = horaEntrada;

			    // Obtener hora de salida desde el TimePicker
			    String horaSalida = obtenerHora(tpHoraSalida);
			    BitacoraCecytem.horaSalida = horaSalida;

			    // Obtener fecha desde el DatePicker
			    String fecha = obtenerFecha(dpFecha);
			    BitacoraCecytem.fecha = fecha;
				 
			            conexion.registrarAlumno();
			            limpiar();}

		
			}
		});
		frmBitacora.getContentPane().add(btnRegistrar);
		//Botón de actualizar
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(156, 452, 96, 23);
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   				
			    BitacoraCecytem.noControl=tfNoControl.getText();
				BitacoraCecytem.nombrePlantel=taNombre.getText();
				//horaEntrada
				
			    // Obtener hora de entrada desde el TimePicker
			    String horaEntrada = obtenerHora(tpHoraEntrada);
			    BitacoraCecytem.horaEntrada = horaEntrada;

			    // Obtener hora de salida desde el TimePicker
			    String horaSalida = obtenerHora(tpHoraSalida);
			    BitacoraCecytem.horaSalida = horaSalida;

			    // Obtener fecha desde el DatePicker
			    String fecha = obtenerFecha(dpFecha);
			    BitacoraCecytem.fecha = fecha;
			     conexion.actualizarAlumno();
			     limpiar();}


			
		});
		frmBitacora.getContentPane().add(btnActualizar);
		//Botón de eliminar alumno 
		JButton btnBaja = new JButton("Baja");
		btnBaja.setBounds(262, 452, 74, 23);
		btnBaja.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
			    conexion.eliminarAlumno();
		        limpiar();
		        

              
			}
		});
		frmBitacora.getContentPane().add(btnBaja);
		//Botón de salir 
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(360, 452, 61, 23);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frmBitacora.getContentPane().add(btnSalir);
		//Botón de consultar 
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(449, 452, 98, 23);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion.consultarAlumno();
				tfNoControl.setText(BitacoraCecytem.noControl);
				taNombre.setText(BitacoraCecytem.nombrePlantel);
		        // Establecer la hora de entrada en el TimePicker
		        if (BitacoraCecytem.horaEntrada != null && !BitacoraCecytem.horaEntrada.isEmpty()) {
		            LocalTime horaEntrada = LocalTime.parse(BitacoraCecytem.horaEntrada, DateTimeFormatter.ofPattern("HH:mm"));
		            tpHoraEntrada.setTime(horaEntrada);
		        }

		        // Establecer la hora de salida en el TimePicker
		        if (BitacoraCecytem.horaSalida != null && !BitacoraCecytem.horaSalida.isEmpty()) {
		            LocalTime horaSalida = LocalTime.parse(BitacoraCecytem.horaSalida, DateTimeFormatter.ofPattern("HH:mm"));
		            tpHoraSalida.setTime(horaSalida);
		        }

		        // Establecer la fecha en el DatePicker
		        if (BitacoraCecytem.fecha != null && !BitacoraCecytem.fecha.isEmpty()) {
		            LocalDate fecha = LocalDate.parse(BitacoraCecytem.fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		            dpFecha.setDate(fecha);
		        }
			}
		});
		frmBitacora.getContentPane().add(btnConsultar);
		
	    taNombre = new JTextArea();
        taNombre.setBounds(175, 100, 129, 67);
        taNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Validación de 100 caracteres
                if (taNombre.getText().length() >= 100) {
                    e.consume();
                }

                // Validar solo letras, números, espacios, puntos, comas, ñ, tildes y letras con acentos
                char c = e.getKeyChar();
                if (!(Character.isLetterOrDigit(c) || c == ' ' || c == '.' || c == ',' || 
                      c == 'ñ' || c == 'Ñ' ||
                      c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú' ||
                      c == 'Á' || c == 'É' || c == 'Í' || c == 'Ó' || c == 'Ú')) {
                    e.consume();
                }
            }
        });
        frmBitacora.getContentPane().add(taNombre);
	}
	private String obtenerHora(TimePicker timePicker) {
	    String hora = "";
	    try {
	        String horaTexto = timePicker.getText();
	        if (horaTexto != null && !horaTexto.isEmpty()) {
	            hora = horaTexto.substring(0, 5); // Obtener solo HH:mm
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace(); // Manejar cualquier excepción que pueda ocurrir
	    }
	    return hora;
	}

	// Método para obtener la fecha desde el DatePicker
	private String obtenerFecha(DatePicker datePicker) {
	    String fecha = "";
	    try {
	        String fechaTexto = datePicker.getText();
	        if (fechaTexto != null && !fechaTexto.isEmpty()) {
	            fecha = fechaTexto; // La fecha ya viene en formato dd/MM/yyyy
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace(); // Manejar cualquier excepción que pueda ocurrir
	    }
	    return fecha;
	}

	public void limpiar() {
	    // Limpiar campos de texto
	    tfNoControl.setText("");
	    taNombre.setText("");

	    // Limpiar TimePicker de hora de entrada
	    tpHoraEntrada.clear();
	    // Limpiar TimePicker de hora de salida
	    tpHoraSalida.clear();
	    // Limpiar DatePicker de fecha
	    dpFecha.clear();

	    // Resetear variables estáticas en la clase BitacoraCecytem
	    BitacoraCecytem.noControl = "";
	    BitacoraCecytem.nombrePlantel = "";
	    BitacoraCecytem.horaEntrada = "";
	    BitacoraCecytem.horaSalida = "";
	    BitacoraCecytem.fecha = "";
	}
	//validación de campos 
	private boolean validarCampos() {
	    if (tfNoControl.getText().trim().isEmpty()) {
	        // Mostrar mensaje de error
	        mostrarMensajeError("El campo Número de Control es obligatorio.");
	        return false;
	    }

	    if (taNombre.getText().trim().isEmpty()) {
	        // Mostrar mensaje de error
	        mostrarMensajeError("El campo Nombre de la institución es obligatorio.");
	        return false;
	    }

	    if (tpHoraEntrada.getTime() == null) {
	        // Mostrar mensaje de error
	        mostrarMensajeError("El campo Hora de Entrada es obligatorio.");
	        return false;
	    }

	    if (tpHoraSalida.getTime() == null) {
	        // Mostrar mensaje de error
	        mostrarMensajeError("El campo Hora de Salida es obligatorio.");
	        return false;
	    }

	    if (dpFecha.getDate() == null) {
	        // Mostrar mensaje de error
	        mostrarMensajeError("El campo Fecha es obligatorio.");
	        return false;
	    }

	    return true;
	}
	//mensaje de error si no hay nada ingresado
	private void mostrarMensajeError(String mensaje) {
	    JOptionPane.showMessageDialog(frmBitacora, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
	}
}
