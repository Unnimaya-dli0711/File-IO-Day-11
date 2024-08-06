package policy;

import java.io.*;
import java.util.ArrayList;

class Policy{
    String policy_id;
    String holder_name;
    double policy_amount;
    Policy(String policy_id,String holder_name,double policy_amount){
        this.policy_id=policy_id;
        this.policy_amount=policy_amount;
        this.holder_name=holder_name;
    }

    public String getPolicy_id() {
        return policy_id;
    }

    public void setPolicy_id(String policy_id) {
        this.policy_id = policy_id;
    }

    public String getHolder_name() {
        return holder_name;
    }

    public void setHolder_name(String holder_name) {
        this.holder_name = holder_name;
    }

    public double getPolicy_amount() {
        return policy_amount;
    }

    public void setPolicy_amount(double policy_amount) {
        this.policy_amount = policy_amount;
    }
}
public class PolicyManager {
    static ArrayList<Policy> policies=new ArrayList<>();
    static void fetchToArray(String filepath){
        String policy_id;
        String holder_name;
        double policy_amount;
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(filepath));){
            String string;
            while ((string=bufferedReader.readLine())!=null){
                System.out.println(string);
                String[] stringArray=string.split(",");
                policy_id=stringArray[0];
                holder_name=stringArray[1];
                policy_amount=Double.parseDouble(stringArray[2]);
                policies.add(new Policy(policy_id,holder_name,policy_amount));
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
    static void generateSummary(String filepath){
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(filepath));){

            int count=policies.size();
            double sum=policies.stream()
                    .mapToDouble(policy->policy.policy_amount)
                    .sum();
            bufferedWriter.write("Total Number of Policies: "+count+"\n");
            bufferedWriter.write("Total Policy Amount: "+sum);
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        fetchToArray("src/policy/policies.txt");
        generateSummary("src/policy/summary.txt");
    }
}
