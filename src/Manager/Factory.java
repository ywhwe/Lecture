package src.Manager;

public interface Factory <T extends Manageable>{
	T create();
}
