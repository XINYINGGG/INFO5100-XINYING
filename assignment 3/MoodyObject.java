package assignment3;

public abstract class MoodyObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoodyObject happy = new HappyObject();
		MoodyObject sad = new SadObject();
		PsychaitristObject psychaitrist = new PsychaitristObject();
		psychaitrist.examine(happy);
		psychaitrist.observe(happy);
		psychaitrist.examine(sad);
		psychaitrist.observe(sad);
	}

	protected abstract String getMood();
	protected abstract void expressFeelings();
	public void queryMood() {
		System.out.println("I feel "+ getMood()+ " today!\n");
	}

}
 class SadObject extends MoodyObject{

	protected String getMood(){
		return "sad";
	}
	public void expressFeelings(){
		System.out.println(" 'wah' 'boo hoo' 'weep' 'sob' 'weep' ");
	}
	public String toString(){
		return "Subject cries a lot\n";
	}
}
 class HappyObject extends MoodyObject{
	protected String getMood(){
		return "happy";
	}
	public void expressFeelings(){
		System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
	}
	public String toString(){
		return "Subject laughs a lot\n";
	}
}
 class PsychaitristObject{
	public void examine(MoodyObject moodyObject){
		System.out.println("How are you feeling today?");
		moodyObject.queryMood();
	}
	public void observe(MoodyObject moodyObject){
		moodyObject.expressFeelings();
		System.out.println("Observation:" + moodyObject.toString() );
	}
}








