# Java compiler
JAVAC = javac

# Java runtime
JAVA = java

# Main class
MAIN_CLASS = Main

# Source files
SOURCES = Admin.java User.java Account.java CheckingAccount.java SavingsAccount.java ATMSystem.java Main.java

# Class files
CLASSES = $(SOURCES:.java=.class)

# Default target
.PHONY: all
all: $(MAIN_CLASS)

# Compile Java source files
$(CLASSES): %.class: %.java
	$(JAVAC) $^

# Main target
$(MAIN_CLASS): User.class $(CLASSES)
	$(JAVA) $(MAIN_CLASS)

# Clean target
.PHONY: clean
clean:
	rm -f $(CLASSES)
