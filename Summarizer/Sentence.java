
import java.util.ArrayList;
import java.util.List;


public class Sentence {
	
	public int sentence_number;
	public String sentence_text;
	public List<Concept> concept_list = new ArrayList<Concept>();
	public List<Itemset> FrequentItemsSen = new ArrayList<Itemset>();
	public double sentence_score;
	
	
	public void AddNewConcept(Concept new_concept)
	{
		Boolean already_exist = false;
		/*
		if(!(new_concept.semantic_type.equals("qnco")
				|| new_concept.semantic_type.equals("qlco")
				|| new_concept.semantic_type.equals("tmco")
				|| new_concept.semantic_type.equals("ftcn")
				|| new_concept.semantic_type.equals("idcn")
				|| new_concept.semantic_type.equals("inpr")
				|| new_concept.semantic_type.equals("menp")
				|| new_concept.semantic_type.equals("spco")
				|| new_concept.semantic_type.equals("lang")))
			*/	
		{
		for(int i = 0; i < concept_list.size(); i++)
		{
			if(new_concept.concept_name.equals(concept_list.get(i).concept_name) && new_concept.semantic_type.equals(concept_list.get(i).semantic_type))
			{
				already_exist = true;
				break;
			}
		}
		
		if(already_exist == false)
			this.concept_list.add(new_concept);
	}
	}
	public Boolean IsContainItem(String item_name)
	{
		for(int i = 0; i < concept_list.size(); i++)
		{
			if (item_name.equals(concept_list.get(i).semantic_type))
				return true;
		}
		return false;
	}
	
	//checks if a sentence covers a specific Frequent itemset or not
	public Boolean ItemsetOccurance(Itemset a)
	{
		int matchCount=0;
		for(int i=0; i<a.Itemsets.size(); i++)
		{
			for(int j=0; j<this.concept_list.size(); j++)
			{
				if(a.Itemsets.get(i).equals(this.concept_list.get(j).concept_name))
				{
					matchCount++;
					break;
				}
			}
		}
		if(matchCount == a.Itemsets.size())
			return true;
		else
		    return false;
	}
	
	
	//calculate the number of common frequent itemsets between 2 sentences
	public int Count_FreqItems(Sentence S2)
	{
		int Count_FI=0,L2;
		L2= S2.FrequentItemsSen.size();
		for (int i=0; i<L2; i++ )
		{
			if (this.ItemsetOccurance(S2.FrequentItemsSen.get(i)))
			{
				Count_FI++;
			}
		}
		
		return Count_FI;
	}
	
	
}
	

