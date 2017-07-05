
		package veniq.view;
		import veniq.test.*;
		import java.awt.event.ActionEvent;
		import java.awt.event.ActionListener;

		public class GenerationGenerator implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Life.population++;
				System.out.println(Life.population);
				MainView.mas = Life.check(MainView.mas);	
				MainView.repaintFrame();
				
			}

		}
