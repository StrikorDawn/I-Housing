package com.example.i_housing

import android.view.MotionEvent
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.math.pow
import kotlin.math.sqrt
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import kotlinx.coroutines.launch
import kotlin.math.roundToInt



@Composable
fun FilterApartments(navController: NavController) {
	var housingType by remember{ mutableStateOf("Any") }
	var availableFor by remember{ mutableStateOf("Any") }

	var minimumDistance by remember { mutableStateOf(0) }
	var maximumDistance by remember { mutableStateOf(10) }
	var minimumPrice by remember { mutableStateOf(0) }
	var maximumPrice by remember { mutableStateOf(10000) }
	var minimumBathrooms by remember { mutableStateOf(0) }
	var maximumBathrooms by remember { mutableStateOf(5) }
	var minimumFridges by remember { mutableStateOf(0) }
	var maximumFridges by remember { mutableStateOf(3) }


	var isPrivateRooms by remember { mutableStateOf(false) }
	var isWasher by remember { mutableStateOf(false) }
	var isClubhouse by remember { mutableStateOf(false) }
	var isGym by remember { mutableStateOf(false) }
	var isHottub by remember { mutableStateOf(false) }

	Column(
		modifier = Modifier.verticalScroll(rememberScrollState())
	){
		Row (modifier = Modifier.padding(vertical = 10.dp)){
			Text(text = "Housing Type: ",
				fontSize = 20.sp,
				modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
			)
			DropDown(listOf("Any","Married","Single")){
				SelectedText ->
				housingType = SelectedText
			}
		}
		Row (modifier = Modifier.padding(vertical = 10.dp)){
			Text(text = "Available for: ",
				fontSize = 20.sp,
				modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
			)
			DropDown(listOf("Any","Men","Women")){
				SelectedText ->
					availableFor = SelectedText
			}
		}
		Text(text = "Distance from campus (miles): ",
			fontSize = 20.sp,
			modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
		)
		RangeSlider(
			modifier = Modifier
				.padding(vertical = 40.dp, horizontal = 48.dp)
				.fillMaxWidth(),
			rangeColor = Color(73, 147, 236),
			backColor = Color(203, 225, 246),
			barHeight = 8.dp,
			circleRadius = 10.dp,
			progress1InitialValue = 0f,
			progress2InitialValue = 1f,
			tooltipSpacing = 10.dp,
			tooltipWidth = 40.dp,
			tooltipHeight = 30.dp,
			cornerRadius = CornerRadius(32f, 32f),
			tooltipTriangleSize = 8.dp,
			size = 10,
		) { progress1, progress2 ->
				minimumDistance = progress1.toInt()
				maximumDistance = progress2.toInt()
		}
		Text(text = "Price per semester: ",
			fontSize = 20.sp,
			modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
		)
		RangeSlider(
			modifier = Modifier
				.padding(vertical = 40.dp, horizontal = 48.dp)
				.fillMaxWidth(),
			rangeColor = Color(73, 147, 236),
			backColor = Color(203, 225, 246),
			barHeight = 8.dp,
			circleRadius = 10.dp,
			progress1InitialValue = 0f,
			progress2InitialValue = 1f,
			tooltipSpacing = 10.dp,
			tooltipWidth = 40.dp,
			tooltipHeight = 30.dp,
			cornerRadius = CornerRadius(32f, 32f),
			tooltipTriangleSize = 8.dp,
			size = 10000,
		) { progress1, progress2 ->
				minimumPrice = progress1.toInt()
				maximumPrice = progress2.toInt()
		}
		Text(text = "Bathrooms: ",
		fontSize = 20.sp,
		modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
		)
		RangeSlider(
			modifier = Modifier
				.padding(vertical = 40.dp, horizontal = 48.dp)
				.fillMaxWidth(),
			rangeColor = Color(73, 147, 236),
			backColor = Color(203, 225, 246),
			barHeight = 8.dp,
			circleRadius = 10.dp,
			progress1InitialValue = 0f,
			progress2InitialValue = 1f,
			tooltipSpacing = 10.dp,
			tooltipWidth = 40.dp,
			tooltipHeight = 30.dp,
			cornerRadius = CornerRadius(32f, 32f),
			tooltipTriangleSize = 8.dp,
			size = 5,
		) { progress1, progress2 ->
				minimumBathrooms = progress1.toInt()
				maximumBathrooms = progress2.toInt()
		}
		Text(text = "Fridges: ",
			fontSize = 20.sp,
			modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
		)
		RangeSlider(
			modifier = Modifier
				.padding(vertical = 40.dp, horizontal = 48.dp)
				.fillMaxWidth(),
			rangeColor = Color(73, 147, 236),
			backColor = Color(203, 225, 246),
			barHeight = 8.dp,
			circleRadius = 10.dp,
			progress1InitialValue = 0f,
			progress2InitialValue = 1f,
			tooltipSpacing = 10.dp,
			tooltipWidth = 40.dp,
			tooltipHeight = 30.dp,
			cornerRadius = CornerRadius(32f, 32f),
			tooltipTriangleSize = 8.dp,
			size = 3,
		) { progress1, progress2 ->
				minimumFridges = progress1.toInt()
				maximumFridges = progress2.toInt()
		}
		var verticalPadding = 35.dp
		Text(text = "Check the following if you only want to see apartments with these amenities ",
			fontSize = 20.sp,
			modifier = Modifier.padding(horizontal = 16.dp).paddingFromBaseline(top = verticalPadding),
		)
		Row{
			Text(text = "Private Rooms: ",
				fontSize = 20.sp,
				modifier = Modifier.padding(horizontal = 16.dp).paddingFromBaseline(top = verticalPadding),
			)
			Spacer(Modifier.weight(1f))
			SimpleCheckboxComponent(){
				 isCheckedValue:Boolean ->
					isPrivateRooms = isCheckedValue
			}
		}
		Row {
			Text(text = "In-Unit Washer/Dryer: ",
				fontSize = 20.sp,
				modifier = Modifier.padding(horizontal = 16.dp).paddingFromBaseline(top = verticalPadding),
			)
			Spacer(Modifier.weight(1f))
			SimpleCheckboxComponent(){
				isCheckedValue:Boolean ->
					isWasher = isCheckedValue
			}
		}
		Row {
			Text(text = "Club-house: ",
				fontSize = 20.sp,
				modifier = Modifier.padding( horizontal = 16.dp).paddingFromBaseline(top = verticalPadding),
			)
			Spacer(Modifier.weight(1f))
			SimpleCheckboxComponent(){
				isCheckedValue:Boolean ->
					isClubhouse = isCheckedValue
			}
		}
		Row {
			Text(text = "Gym: ",
				fontSize = 20.sp,
				modifier = Modifier.padding( horizontal = 16.dp).paddingFromBaseline(top = verticalPadding),
			)
			Spacer(Modifier.weight(1f))
			SimpleCheckboxComponent(){
				isCheckedValue:Boolean ->
					isGym = isCheckedValue
			}
		}
		Row {
			Text(text = "Hot-tub: ",
				fontSize = 20.sp,
				modifier = Modifier.padding(horizontal = 16.dp).paddingFromBaseline(top = verticalPadding),
			)
			Spacer(Modifier.weight(1f))
			SimpleCheckboxComponent(){
				isCheckedValue:Boolean ->
					isHottub = isCheckedValue
			}
		}


	}

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(Items: List<String>,
			 onTextChange: (String) -> Unit
){
	val list = Items

	var selectedText by remember {
		mutableStateOf(list[0])
	}

	var isExpanded by remember {
		mutableStateOf(false)
	}
	Column (
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 8.dp),
//		horizontalAlignment = Alignment.CenterHorizontally
	) {
		ExposedDropdownMenuBox(expanded = isExpanded,
			onExpandedChange = {isExpanded = !isExpanded}
		) {
			TextField(
				modifier = Modifier.menuAnchor(),
				value = selectedText,
				onValueChange = {},
				readOnly = true,
				trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) }
			)

			ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
				list.forEachIndexed { index, text ->
					DropdownMenuItem(
						text = { Text(text = text) },
						onClick = {
							selectedText = list[index]
							isExpanded = false
							onTextChange(selectedText)

						},
						contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
					)
				}
			}
		}
	}

}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalTextApi::class)
@Composable
fun RangeSlider(
	modifier: Modifier,
	rangeColor: Color,
	backColor: Color,
	barHeight: Dp,
	circleRadius: Dp,
	cornerRadius: CornerRadius,
	progress1InitialValue: Float,
	progress2InitialValue: Float,
	tooltipSpacing: Dp,
	tooltipWidth: Dp,
	tooltipHeight: Dp,
	tooltipTriangleSize: Dp,
	size: Int,
	onProgressChanged: (progress1: Float, progress2: Float) -> Unit
) {

	val circleRadiusInPx = with(LocalDensity.current) { circleRadius.toPx() }
	val bottomRangeStartValue = 10
	var progress1 by remember {
		mutableStateOf(progress1InitialValue)
	}
	var progress2 by remember {
		mutableStateOf(progress2InitialValue)
	}

	var width by remember {
		mutableStateOf(0f)
	}

	var height by remember {
		mutableStateOf(0f)
	}

	var leftCircleDragging by remember {
		mutableStateOf(false)
	}

	var rightCircleDragging by remember {
		mutableStateOf(false)
	}

	val leftTooltipOverlapping by remember {
		derivedStateOf { mutableStateOf(false) }
	}

	var leftCircleOffset by remember {
		mutableStateOf(Offset.Zero)
	}
	var rightCircleOffset by remember {
		mutableStateOf(Offset.Zero)
	}

	val scaleAnim1 by animateFloatAsState(
		targetValue = if (leftCircleDragging) 2f else 1f,
		animationSpec = tween(durationMillis = 300)
	)

	val scaleAnim2 by animateFloatAsState(
		targetValue = if (rightCircleDragging) 2f else 1f,
		animationSpec = tween(durationMillis = 300)
	)

	val tooltipAnim1 by animateFloatAsState(
		targetValue = if (leftTooltipOverlapping.value) -180f else 0f,
		animationSpec = tween(durationMillis = 300)
	)

	val path = remember {
		Path()
	}

	val textMeasurer = rememberTextMeasurer()


	Canvas(
		modifier = modifier
			.height(barHeight)
			.pointerInteropFilter(
				onTouchEvent = { motionEvent ->

					when (motionEvent.action) {
						MotionEvent.ACTION_DOWN -> {
							val x = motionEvent.x
							val y = motionEvent.y
							val dis1 = sqrt(
								(x - leftCircleOffset.x).pow(2) + (y - leftCircleOffset.y).pow(2)
							)
							val dis2 = sqrt(
								(x - rightCircleOffset.x).pow(2) + (y - rightCircleOffset.y).pow(2)
							)

							if (dis1 < circleRadiusInPx) { // left circle clicked
								leftCircleDragging = true
							} else if (dis2 < circleRadiusInPx) { // right circle clicked
								rightCircleDragging = true
							}
						}

						MotionEvent.ACTION_MOVE -> {
							val x = motionEvent.x

							if (leftCircleDragging) {
								progress1 = if (x <= 0) {
									0f
								} else if (x >= width * progress2) {
									progress2
								} else {
									x / width
								}
								leftCircleOffset = leftCircleOffset.copy(x = width * progress1)
							} else if (rightCircleDragging) {
								progress2 = if (x >= width) {
									1f
								} else if (x <= width * progress1) {
									progress1
								} else {
									x / width
								}
								rightCircleOffset = rightCircleOffset.copy(x = width * progress2)
							}
						}

						MotionEvent.ACTION_UP -> {
							leftCircleDragging = false
							rightCircleDragging = false
							onProgressChanged(progress1, progress2)
						}
					}
					true
				}
			)
			.onGloballyPositioned {
				leftCircleOffset = Offset(x = it.size.width * progress1, y = it.size.height / 2f)
				rightCircleOffset = Offset(x = it.size.width * progress2, y = it.size.height / 2f)
			}
	) {
		width = this.size.width
		height = this.size.height

		drawRoundRect(
			color = backColor,
			cornerRadius = cornerRadius,
			topLeft = Offset(x = 0f, y = barHeight.toPx() / 4f),
			size = Size(width = width, height = barHeight.toPx() / 2f)
		)

		//draw inner rect (between two circles)
		drawRect(
			color = rangeColor,
			topLeft = Offset(x = width * progress1, y = 0f),
			size = Size(width = width * (progress2 - progress1), height = height)
		)

		//draw left circle
		scale(scaleAnim1, pivot = leftCircleOffset) {
			drawCircle(
				color = rangeColor.copy(alpha = 0.2f),
				radius = circleRadius.toPx(),
				center = leftCircleOffset
			)
		}
		drawCircle(
			color = rangeColor,
			radius = circleRadius.toPx(),
			center = leftCircleOffset
		)

		//draw right circle
		scale(scaleAnim2, pivot = rightCircleOffset) {
			drawCircle(
				color = rangeColor.copy(alpha = 0.2f),
				radius = circleRadius.toPx(),
				center = rightCircleOffset
			)
		}
		drawCircle(
			color = rangeColor,
			radius = circleRadius.toPx(),
			center = rightCircleOffset,
		)

		//draw left Tooltip
		val leftL = leftCircleOffset.x - tooltipWidth.toPx() / 2f
		val topL =
			leftCircleOffset.y - tooltipSpacing.toPx() - circleRadiusInPx - tooltipHeight.toPx()

		val leftR = rightCircleOffset.x - tooltipWidth.toPx() / 2f
		val topR =
			rightCircleOffset.y - tooltipSpacing.toPx() - circleRadiusInPx - tooltipHeight.toPx()

		if (leftCircleDragging || rightCircleDragging) {
			leftTooltipOverlapping.value = (leftL + tooltipWidth.toPx()) >= leftR
		}
		rotate(tooltipAnim1, pivot = leftCircleOffset) {
			drawPath(
				path.apply {
					reset()
					addRoundRect(
						RoundRect(
							left = leftL,
							top = topL,
							right = leftL + tooltipWidth.toPx(),
							bottom = topL + tooltipHeight.toPx(),
							cornerRadius = CornerRadius(x = 15f, y = 15f)
						)
					)
					moveTo(
						x = leftCircleOffset.x - tooltipTriangleSize.toPx(),
						y = leftCircleOffset.y - circleRadiusInPx - tooltipSpacing.toPx()
					)
					relativeLineTo(tooltipTriangleSize.toPx(), tooltipTriangleSize.toPx())
					relativeLineTo(tooltipTriangleSize.toPx(), -tooltipTriangleSize.toPx())
					close()
				},
				color = Color(191, 0, 0)
			)
		}

		//draw right Tooltip
		drawPath(
			path.apply {
				reset()
				addRoundRect(
					RoundRect(
						left = leftR,
						top = topR,
						right = leftR + tooltipWidth.toPx(),
						bottom = topR + tooltipHeight.toPx(),
						cornerRadius = CornerRadius(x = 15f, y = 15f)
					)
				)
				moveTo(
					x = rightCircleOffset.x - tooltipTriangleSize.toPx(),
					y = rightCircleOffset.y - circleRadiusInPx - tooltipSpacing.toPx()
				)
				relativeLineTo(tooltipTriangleSize.toPx(), tooltipTriangleSize.toPx())
				relativeLineTo(tooltipTriangleSize.toPx(), -tooltipTriangleSize.toPx())
				close()
			},
			color = Color.Red
		)
		val textLeft = (progress1 * size).roundToInt().toString()
		var textLayoutResult = textMeasurer.measure(
			text = AnnotatedString(textLeft),
			style = TextStyle(color = Color.White)
		)
		var textSize = textLayoutResult.size

		rotate(tooltipAnim1, pivot = leftCircleOffset) {
			drawText(
				textLayoutResult = textLayoutResult,
				topLeft = Offset(
					x = leftL + tooltipWidth.toPx() / 2 - textSize.width / 2,
					y = topL + tooltipHeight.toPx() / 2 - textSize.height / 2
				)
			)
		}
//THIS MAY NOT WORK
		val textRight = (progress2 * size).roundToInt().toString()
		textLayoutResult = textMeasurer.measure(
			text = AnnotatedString(textRight),
			style = TextStyle(color = Color.White)
		)
		textSize = textLayoutResult.size

		drawText(
			textLayoutResult = textLayoutResult,
			topLeft = Offset(
				x = leftR + tooltipWidth.toPx() / 2 - textSize.width / 2,
				y = topR + tooltipHeight.toPx() / 2 - textSize.height / 2
			),
		)
	}
}

@Composable
fun SimpleCheckboxComponent(onCheckedChange: (Boolean) -> Unit) {
	// in below line we are setting
	// the state of our checkbox.
	val checkedState = remember { mutableStateOf(false) }
	// in below line we are displaying a row
	// and we are creating a checkbox in a row.
	Row {
		Checkbox(
			// below line we are setting
			// the state of checkbox.
			checked = checkedState.value,
			// below line is use to add padding
			// to our checkbox.
			modifier = Modifier.padding(start = 0.dp, top = 2.dp, end= 140.dp, bottom = 2.dp),
			// below line is use to add on check
			// change to our checkbox.
			onCheckedChange = {
				checkedState.value = it

		  	},
		)
		// below line is use to add text to our check box and we are
		// adding padding to our text of checkbox
	}
}

