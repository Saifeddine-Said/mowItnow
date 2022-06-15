package com.highfi;

import com.highfi.entity.Coordinate;
import com.highfi.entity.Lawn;
import com.highfi.entity.Mower;
import com.highfi.enums.Orientation;
import com.highfi.service.FileDataReader;
import com.highfi.service.InstructionRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * To run this program, we need to pass the argument to the main class
 * use the "Edit Configurations …" menu item under "Run", "Program arguments" text field where we specify the arguments file path
 */
public class MainApplication {

    private static final String SPACE = " ";

    public static void main(String[] args) {

        // read File data and execute the treatment
        if (args.length == 1) {
            try {
                List<String> linesData = FileDataReader.parseDataFile(args[0]);
                // get the two first
                String[] lawnMaxPosition = linesData.get(0).split(SPACE);
                if (lawnMaxPosition.length == 2) {
                    Lawn lawn = new Lawn(new Coordinate(Integer.valueOf(lawnMaxPosition[0]), Integer.valueOf(lawnMaxPosition[1])));
                    // SET mowers
                    List<Mower> mowers = createMowers(linesData);
                    mowers.stream().forEach(mower -> InstructionRunner.executeMowerInstruction(mower, lawn));
                }
            } catch (Exception ex) {
                //TODO TO BE REPLACED BY LOGGER
                System.err.println(ex.getMessage());
            }
        }
    }

    /**
     * Create mowers by getting the Coordinate(x,y) and the orientation
     *
     * @param data list of data retrieve from file
     * @return list of Mowers
     */
    protected static List<Mower> createMowers(List<String> data) {
        List<Mower> mowers = new ArrayList<>();
        if (data != null) {
            for (int i = 1; i < data.size(); i = i + 2) {
                String[] position = data.get(i).split(SPACE);
                int x = Integer.valueOf(position[0]);
                int y = Integer.valueOf(position[1]);
                String orientation = position[2];
                Orientation orientationByCode = Orientation.getOrientationByCode(orientation);
                Mower mower = new Mower(new Coordinate(x, y), orientationByCode, data.get(i + 1));
                mowers.add(mower);
            }
            return mowers;
        } else
            throw new NullPointerException("No Data Found ");
    }

}
