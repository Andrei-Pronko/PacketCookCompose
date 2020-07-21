package com.mentarey.packet.cook.ui.cost

import androidx.compose.*
import androidx.ui.core.Alignment
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Row
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.preferredHeight
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.rounded.Add
import androidx.ui.material.icons.rounded.Remove
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.mentarey.packet.cook.R
import com.mentarey.packet.cook.ui.ext.round

@Composable
fun CostPickerWidget(
    count: Int,
    cost: Double,
    minCount: Int = 1,
    onTotalCostChanged: (Double) -> Unit = {}
) {
    var countState by state { count }
    var totalCostState by state { countState * cost }

    onCommit(countState) {
        totalCostState = (countState * cost).round()
        onTotalCostChanged(totalCostState)
    }

    val rubSymbol = ContextAmbient.current.getString(R.string.symbol_currency)
    Row(
        modifier = Modifier.preferredHeight(50.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalGravity = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1F),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalGravity = Alignment.CenterVertically
        ) {
            val removeClick = Modifier.clickable {
                if (countState > minCount)
                    countState--
            }
            val addClick = Modifier.clickable {
                if (countState >= minCount)
                    countState++
            }
            Image(asset = Icons.Rounded.Remove, modifier = Modifier.weight(1F) + removeClick)
            Text(
                text = countState.toString(),
                modifier = Modifier.weight(1F),
                textAlign = TextAlign.Center
            )
            Image(asset = Icons.Rounded.Add, modifier = Modifier.weight(1F) + addClick)
        }
        Row(
            modifier = Modifier.weight(1F),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalGravity = Alignment.CenterVertically
        ) {
            Text(
                text = "$cost $rubSymbol",
                modifier = Modifier.weight(1F),
                textAlign = TextAlign.Center
            )
            Text(
                text = "$totalCostState $rubSymbol",
                modifier = Modifier.weight(1F),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Preview
fun CostPickerWidgetPreview() {
    CostPickerWidget(1, 9.9) {}
}