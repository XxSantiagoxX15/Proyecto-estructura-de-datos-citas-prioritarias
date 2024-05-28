package co.edu.unbosque.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


import co.edu.unbosque.model.Task;
import co.edu.unbosque.model.TaskManager;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	private TaskManager taskManager;
	private Scanner scanner;
	

	private VistaConsola vc;
public Controller() {
	

	vc=new VistaConsola();
	scanner = new Scanner(System.in);
    taskManager = new TaskManager(); /
    funcionar();
	
}

public void funcionar() {
	String menu=" 1. Agregar \n 2. ver tareas\n 3. ver tareas no prioritarias\n 4. marcar como listas las prioritarias.\n 5. desmarcar tareas prioritarias \n 6. marcar tarea no prioritaria\n 7. desmarcar tarea no prioritaria\n 8. Buscar tarea prioritaria.\n 9. buscar tarea no prioritaria\n 10. salir";
	int option=0;
	do {
		option= vc.ReadInteger(menu);
		switch (option) {
		case 1:insertar();
		break;
		case 2: taskManager.imprimirColas();
		break;
		case 3:taskManager.imprimirlista();
		break;
		case 4: taskManager.check();
		break;
		case 5: taskManager.rewind();
		break;
		case 6: marcarnoprio();
		break;
		case 7: taskManager.descarmarnoprio();
		break;
		case 8:consultarprio();
		break;
		case 9: consultarnoprio();
		break;
		case 10:vc.SeeInfo("gracias por entrar");
		default:vc.SeeInfo("Incorrect option,please selected diferent option");

		}

	}while(option != 10);

}
		
		
		
	
	public void insertar() {
		

		System.out.println("Ingrese los datos de la tarea:");

        System.out.print("Título: ");
        String title = scanner.nextLine();

        System.out.print("Descripción: ");
        String description = scanner.nextLine();

        System.out.print("Fecha de vencimiento (dd/MM/yyyy): ");
        String dueDateString = scanner.nextLine();
         
        
        String  state= "Disponible";

        
        Date dueDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       
        try {
            dueDate = dateFormat.parse(dueDateString);
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha. La tarea no se agregará.");
            return;
        }

        // Crear la tarea con los datos ingresados por el usuario
        Task task = new Task(title, description, state, new Date(), dueDate);

        // Insertar la tarea en TaskManager
        taskManager.insert(task);
	
  }
public void marcarnoprio() {
String title=	vc.ReadString("Cual es el titulo de la tarea que quiere marcar como lista");
taskManager.marcarnoprio(title);
}

public void consultarnoprio() {
	String title=vc.ReadString("ingrese el titulo");
	taskManager.consultarnoprio(title);
	
}
public void consultarprio() {
	String title=vc.ReadString("Ingrese el titulo");
	taskManager.Consultar(title);
}

}

