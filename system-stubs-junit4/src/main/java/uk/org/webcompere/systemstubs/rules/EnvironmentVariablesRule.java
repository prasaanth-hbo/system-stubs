package uk.org.webcompere.systemstubs.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;

import java.util.Map;

import static uk.org.webcompere.systemstubs.rules.internal.Statements.toStatement;

/**
 * JUnit 4 rule which sets up the environment variables around whatever JUnit 4 is running
 */
public class EnvironmentVariablesRule extends EnvironmentVariables implements TestRule {

    /**
     * Default constructor provides restoration of the environment and the ability to set values
     */
    public EnvironmentVariablesRule() {
    }

    /**
     * Construct with variables that will be set when the rule is active
     * @param name name of the first variable
     * @param value value of the first variable
     * @param others pairs of name/values as Strings
     */
    public EnvironmentVariablesRule(String name, String value, String... others) {
        super(name, value, others);
    }

    /**
     * Construct with some variables to apply when active
     * @param variables map of variables to apply when active
     */
    public EnvironmentVariablesRule(Map<String, String> variables) {
        super(variables);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Statement apply(Statement statement, Description description) {
        return toStatement(statement, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnvironmentVariablesRule and(String name, String value) {
        return new EnvironmentVariablesRule(super.and(name, value).getVariables());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnvironmentVariablesRule set(String name, String value) {
        return (EnvironmentVariablesRule)super.set(name, value);
    }
}
