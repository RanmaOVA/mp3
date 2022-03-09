// *************************
// JavaFX mp3 music player
// *************************
package application;

import java.io.File;
 
public class Controller implements Initializable{
    
	@FXML
	private Pane pane;
	@FXML
	private Label songLabel;
	@FXML
	private Button playButton, pauseButton, resetButton, previousButton, nextButton;
	@FXML
	private ComboBox<String> speedBox;
	@FXML
	private Slider volumeSlider;
	@FXML
	private ProgressBar songProgressBar;
	
	private Media media;
	private MediaPlayer mediaPlayer;
	
	private File directory;
	private File[] files;
	
	private ArrayList<File> songs;
	
	private int songNumber;
	private int[] speeds = {25, 50, 75, 100, 125, 150, 175, 200};
	
	private Timer timer;
	private TimerTask task;
	
	private boolean running;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		songs = new ArrayList<File>();
		
		directory = new File("music");
		
		files = directory.listFiles();
		
		if(files != null) {
			
			for(File file : files) {
				
				songs.add(file);
			}
		}