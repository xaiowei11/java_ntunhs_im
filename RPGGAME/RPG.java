package RPGGAME;

public class RPG {
	
	public static void main(String[] args) {
		Warrior warrior = new Warrior ("戰士A", 100, 15, 5);
		Mage mage = new Mage("法師B", 80, 10, 50);
		
		mage.castSpell(warrior);
		warrior.useShield();
		warrior.attack(mage);
		mage.display();
		warrior.display();
	}
}