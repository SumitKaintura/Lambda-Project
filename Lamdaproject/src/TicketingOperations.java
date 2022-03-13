
	import java.util.Date;
	import java.text.SimpleDateFormat;
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;

	public class TicketingOperations {
	    //This method reads the sample.csv file provided and returns a List
	    public List<TicketingData> readTicketingData(String fileName)
	    {   
	        ArrayList list = new ArrayList();
	        try{
	        FileReader fileReader = new FileReader(fileName);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String line;
	        bufferedReader.readLine();
	        
	        while((line=bufferedReader.readLine()) != null)
	        {   
	            String[] data = line.split(",");
	           // double cost = Double.parseDouble(data[2]);
	           // int cameraPixels = Integer.parseInt(data[6]);
	             String dt = data[6];
		         Date ticket_date = new SimpleDateFormat("dd/MM/yyyy").parse(dt);  
	             double total_ticket_amount = Double.parseDouble(data[8]);
	             float travelledKM = Float.parseFloat(data[9]);

	            list.add(new TicketingData(data[0],data[1],data[2],data[3],data[4],data[5],ticket_date,data[7],total_ticket_amount,travelledKM));
	           
	        }
	        }
	        catch (FileNotFoundException fileNotFoundException) 
	        {
	            fileNotFoundException.printStackTrace();
	        } catch (IOException ioException) 
	        {
	            ioException.printStackTrace();
	        }
	        catch (Exception e) {

	            e.printStackTrace();
	        }
	        return null;
	    }
	    //This method sorts the data based on the kms travelled by a bus (route)
	    public List<TicketingData> sortByKmsTravelled(List<TicketingData> ticketingDataList)
	    {   
	        //ArrayList<TicketingData> l1 = new ArrayList<TicketingData>(ticketingDataList);
	        Collections.sort(ticketingDataList);
	        return ticketingDataList;
	    }

	    //This method calculates the total revenue from ticket collection amount
	    public double totalAmountCollected(List<TicketingData> ticketingDataList)
	    {
	       return -1;
	    }

	}

