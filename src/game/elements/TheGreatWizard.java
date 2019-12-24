package game.elements;

import fileio.FileSystem;

import java.io.IOException;

public class TheGreatWizard extends Observer {
    private static TheGreatWizard instance = null;
    private String mInputPath;
    private String mOutputPath;
    private FileSystem fs;

    public static TheGreatWizard getInstance() {
        if (instance == null) {
            instance = new TheGreatWizard();
        }

        return instance;
    }

    public void setPath(String inputPath, String outpuPath) {
        mInputPath = inputPath;
        mOutputPath = outpuPath;

        try {
            fs = new FileSystem(mInputPath, mOutputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileSystem getFile() {
        return fs;
    }

    @Override
    public void update(int state, String firstName, String secondName,
                       int firstPosition, int secondPosition) {
        try {
            switch(state) {
                case 0:
                    if (firstPosition != 1) {
                        System.out.println();
                        fs.writeWord("\n");
                    }

                    System.out.println("~~ Round " + firstPosition + " ~~");
                    fs.writeWord("~~ Round " + firstPosition + " ~~\n");
                    break;
                case 1:
                    System.out.println("\n~~ Results ~~");
                    fs.writeWord("\n~~ Results ~~\n");
                    break;
                case 2:
                    System.out.println("Angel " + firstName + " was spawned at "
                            + firstPosition + " " + secondPosition);
                    fs.writeWord("Angel " + firstName + " was spawned at "
                            + firstPosition + " " + secondPosition + "\n");
                    break;
                case 3:
                    System.out.println(firstName + " helped " + secondName + " " + secondPosition);
                    fs.writeWord(firstName + " helped " + secondName + " " + secondPosition + "\n");
                    break;
                case 4:
                    System.out.println(firstName + " hit " + secondName + " " + secondPosition);
                    fs.writeWord(firstName + " hit " + secondName + " " + secondPosition + "\n");
                    break;
                case 5:
                    System.out.println("Player " + firstName + " " + firstPosition +
                            " was killed by " + secondName + " " + secondPosition);
                    fs.writeWord("Player " + firstName + " " + firstPosition +
                            " was killed by " + secondName + " " + secondPosition + "\n");
                    break;
                case 6:
                    System.out.println(firstName + " " + firstPosition + " reached level " + secondPosition);
                    fs.writeWord(firstName + " " + firstPosition + " reached level " + secondPosition + "\n");
                    break;
                case 7:
                    System.out.println("Player " + firstName + " " + firstPosition + " was killed by an angel");
                    fs.writeWord("Player " + firstName + " " + firstPosition + " was killed by an angel\n");
                    break;
                case 8:
                    System.out.println("Player " + firstName + " " + firstPosition + " was brought to life by an angel");
                    fs.writeWord("Player " + firstName + " " + firstPosition + " was brought to life by an angel\n");
                    break;
                default:
                    break;
            }

            //fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
