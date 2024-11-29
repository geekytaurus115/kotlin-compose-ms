package com.geekytaurus.simplecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import com.geekytaurus.simplecalculator.ui.theme.SimpleCalculatorTheme
import net.objecthunter.exp4j.ExpressionBuilder  // Add this library for expression evaluation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleCalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SimpleCalculator(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun SimpleCalculator(modifier: Modifier) {
    var expression by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("0") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(text = "Calculator",
            modifier = modifier
                .fillMaxWidth()
                .background(
                    Color.DarkGray,
                    shape = RoundedCornerShape(5.dp)
                ),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            )
        Spacer(modifier = Modifier.height(60.dp))
        // Display for the expression
        Text(
            text = expression,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            maxLines = 2
        )

        // Display for the result
        Text(
            text = result,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(64.dp))

        // Button layout
        CalculatorButtons { input ->
            val (newExpression, newResult) = handleInput(expression, input)
            expression = newExpression
            result = newResult
        }
    }
}

@Composable
fun CalculatorButtons(onButtonClick: (String) -> Unit) {
    val buttons = listOf(
        "C", "(", ")", "÷",
        "7", "8", "9", "×",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "=", "B"  // Adding 'B' as backspace
    )

    Column {
        for (i in buttons.indices step 4) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (j in 0 until 4) {
                    CalculatorButton(buttons[i + j], onButtonClick)
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(text: String, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(text) },
        modifier = Modifier
            .size(80.dp)
            .padding(4.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
    ) {
        Text(text = text, fontSize = 24.sp)
    }
}

fun handleInput(currentExpression: String, input: String): Pair<String, String> {
    return when (input) {
        "C" -> Pair("", "0")  // Clear display
        "B" -> if (currentExpression.isNotEmpty()) {
            Pair(currentExpression.dropLast(1), "0")  // Backspace functionality
        } else {
            Pair("", "0")
        }
        "=" -> try {
            val result = evaluateExpression(currentExpression)
            Pair(currentExpression, result)  // Return expression and result
        } catch (e: Exception) {
            Pair(currentExpression, "Error")
        }
        else -> if (currentExpression.isEmpty() && input != ".") {
            Pair(input, "0")  // Set initial input if expression is empty
        } else {
            Pair(currentExpression + input, "0")  // Update expression
        }
    }
}

fun evaluateExpression(expression: String): String {
    return try {
        val exp = ExpressionBuilder(expression.replace("×", "*").replace("÷", "/")).build()
        val result = exp.evaluate()
        if (result == result.toLong().toDouble()) result.toLong().toString() else result.toString()
    } catch (e: Exception) {
        "Error"
    }
}
